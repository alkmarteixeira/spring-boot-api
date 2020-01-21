package br.com.bsaccn.api.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import javax.swing.text.MaskFormatter;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.bsaccn.api.dtos.PessoaFisicaDto;
import br.com.bsaccn.api.dtos.PessoaFisicaSummaryDto;
import br.com.bsaccn.api.model.Pessoa;
import br.com.bsaccn.api.response.Response;
import br.com.bsaccn.api.services.PessoaFisicaService;

@RestController
@RequestMapping("/api/pessoa-fisica")
@CrossOrigin(origins = "*")
public class PessoaFisicaController {
	
	private static final Logger log = LoggerFactory.getLogger(PessoaFisicaController.class);
	
	@Autowired
	private PessoaFisicaService pessoaFisicaService;	
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public PessoaFisicaController() {
	}
	
	/**
	 * Retorna a listagem de pessoas que possuem um CPF.
	 * 
	 * @param cpf
	 * @return ResponseEntity<Response<PessoaFisicaDto>>
	 */
	@GetMapping(value = "/list/{cpf}")
	public ResponseEntity<Response<Page<PessoaFisicaSummaryDto>>> listarPessoasPorCpf(
			@PathVariable("cpf") String cpf,
			@RequestParam(value = "pag", defaultValue = "0") int pag,
			@RequestParam(value = "ord", defaultValue = "id") String ord,
			@RequestParam(value = "dir", defaultValue = "DESC") String dir) {
		log.info("Buscando pessoas por CPF : {}, página: {}", cpf, pag);
		Response<Page<PessoaFisicaSummaryDto>> response = new Response<Page<PessoaFisicaSummaryDto>>();
		Pageable sortedBy = PageRequest.of(pag, this.qtdPorPagina, Sort.by(ord));
		Page<Pessoa> pessoas = this.pessoaFisicaService.buscarPorCpf(cpf, sortedBy);
		Page<PessoaFisicaSummaryDto> pessoasFisicasDto = pessoas.map(pessoa -> this.converterPessoaSummaryDto(pessoa));

		response.setData(pessoasFisicasDto);
		return ResponseEntity.ok(response);
	}

	private PessoaFisicaSummaryDto converterPessoaSummaryDto(Pessoa pessoa) {
		PessoaFisicaSummaryDto dto = new PessoaFisicaSummaryDto();
		MaskFormatter mask;
		try {
			mask = new MaskFormatter("###.###.###-##");
			mask.setValueContainsLiteralCharacters(false);
			dto.setCpf(mask.valueToString(pessoa.getCpf()));
		} catch (ParseException e1) {
			dto.setCpf(pessoa.getCpf());
			e1.printStackTrace();
		}
		dto.setId(pessoa.getId());
		dto.setNome(pessoa.getDsNome());
		if (pessoa.getCartorio() != null)
			dto.setNomeCartorio(pessoa.getCartorio().getNmCartorio());
		return dto;
	}
	
	/**
	 * Retorna uma pessoa.
	 * 
	 * @param pessoaId
	 * @return ResponseEntity<Response<PessoaFisicaDto>>
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<PessoaFisicaDto>> buscarPessoaPorId(@PathVariable("id") long id) {
		log.info("Buscando pessoa por ID : {}", id);
		Response<PessoaFisicaDto> response = new Response<PessoaFisicaDto>();
		Optional<Pessoa> pessoa = this.pessoaFisicaService.buscarPessoaPorId(id);
		
		if (!pessoa.isPresent()) {
			log.info("Pessoa não encontrada para o ID: {}", id);
			response.getErrors().add("Pessoa não encontrada para o id " + id);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.converterPessoaDto(pessoa.get()));
		return ResponseEntity.ok(response);
	}

	private PessoaFisicaDto converterPessoaDto(Pessoa pessoa) {
		PessoaFisicaDto dto = new PessoaFisicaDto();
		String sexo = pessoa.getSexo();
		dto.setId(pessoa.getId());
		dto.setNome(pessoa.getDsNome());
		MaskFormatter mask;
		try {
			mask = new MaskFormatter("###.###.###-##");
			mask.setValueContainsLiteralCharacters(false);
			dto.setCpf(mask.valueToString(pessoa.getCpf()));
		} catch (ParseException e1) {
			dto.setCpf(pessoa.getCpf());
			e1.printStackTrace();
		}
		
		if (sexo != null) {
			if(sexo.equalsIgnoreCase("M"))
				dto.setSexo("Masculino");
			else 
				dto.setSexo("Feminino");			
		}
		
		if (pessoa.getEstadoCivil() != null) {
			if(sexo != null && sexo.equalsIgnoreCase("F"))
				dto.setEstadoCivil(pessoa.getEstadoCivil().getDeEstadoCivilFem());
			else
				dto.setEstadoCivil(pessoa.getEstadoCivil().getDeEstadoCivilMasc());
		}
		
		if (pessoa.getDtNascimento() != null) {
			String formattedDate = pessoa.getDtNascimento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			dto.setDataNascimento(formattedDate);
		}
		
		dto.setProfissao(pessoa.getDeProfissao());
		
		if (pessoa.getNacionalidade() != null)
			if (sexo != null && sexo.equalsIgnoreCase("F"))
				dto.setNacionalidade(pessoa.getNacionalidade().getDeNacionalidadeFem());
			else
				dto.setNacionalidade(pessoa.getNacionalidade().getDeNacionalidadeMasc());
		
		if (pessoa.getNaturalidade() != null)
			dto.setCidadeNaturalidade(pessoa.getNaturalidade().getDsNome());
		else 
			dto.setCidadeNaturalidade(pessoa.getDsCidadeNaturalidade());
			
		
		if (pessoa.getNuTelefone() != null)
			dto.setNuTelefone(pessoa.getNuTelefone());
		
		if (pessoa.getNuCelular() != null)
			dto.setNuCelular(pessoa.getNuCelular());
		
		if (pessoa.getDocumento() != null) {
			dto.setDocIdentidade(pessoa.getDocumento().getDocIdentidade());
			dto.setDocDsSgOrgaoEmissor(pessoa.getDocumento().getDsOrgaoEmissor());
			if (pessoa.getDocumento().getOrgaoEmissor() != null)
				dto.setDocUfOrgaoEmissor(pessoa.getDocumento().getOrgaoEmissor().getDsSiglaOrgaoEmissor());
			dto.setDocDataEmissao(pessoa.getDocumento().getDtEmissao().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			dto.setDocUfOrgaoEmissor(pessoa.getDocumento().getUfOrgaoEmissor());
			String pathImagemDocumento = pessoa.getDocumento().getImagemDocumento();
			List<String> imagensDocumento = new ArrayList<String>();
			final File dir = new File(pathImagemDocumento);
			for(final File imgFile : dir.listFiles()) {
				byte[] fileContent;
				try {
					fileContent = FileUtils.readFileToByteArray(imgFile);
					String encodedString = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(fileContent);
					imagensDocumento.add(encodedString);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (!imagensDocumento.isEmpty())
				dto.setImagemDocumento(imagensDocumento);
		}
		
		if (pessoa.getFicha() != null) {
			dto.setNumeroFicha(pessoa.getFicha().getNuFicha());
			dto.setDataFicha(pessoa.getFicha().getDtFicha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		}
		
		dto.setMae(pessoa.getNmMae());
		dto.setPai(pessoa.getNmPai());
		
		if (pessoa.getEndereco() != null) {
			String cep = "";
			try {
				mask = new MaskFormatter("#####-##");
				mask.setValueContainsLiteralCharacters(false);
				cep = mask.valueToString(pessoa.getEndereco().getCep());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			String enderecoCompleto = 
					pessoa.getEndereco().getDsEndreco() 
					+ (!pessoa.getEndereco().getDsNumeroEndereco().isEmpty() ? ", Nº " + pessoa.getEndereco().getDsNumeroEndereco() : "")
					+ (!pessoa.getEndereco().getDsComplemento().isEmpty() ? ", " + pessoa.getEndereco().getDsComplemento() : "")
					+ (!pessoa.getEndereco().getDsBairro().isEmpty() ? ", " + pessoa.getEndereco().getDsBairro() : "")
					+ (!cep.isEmpty() ? " - CEP: " + cep : ""); 
			dto.setenderecoCompleto(enderecoCompleto);
			if (pessoa.getEndereco().getCidade() != null) {
				dto.setCidadeEndereco(pessoa.getEndereco().getCidade().getDsNome());
				dto.setUfEndereco(pessoa.getEndereco().getCidade().getUf());
			}else {
				dto.setCidadeEndereco(pessoa.getEndereco().getDsOutraCidade());
				dto.setUfEndereco("EX");
			}
		}
		
		dto.setEmail(pessoa.getEmail());
		dto.setObservacao(pessoa.getDsObservacao());
		String pathFoto = pessoa.getImagemFoto();
		if (pathFoto != null) {
			try {
				byte[] fileContent = FileUtils.readFileToByteArray(new File(pathFoto));
				String encodedString = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(fileContent);
				dto.setImagemFoto(encodedString);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
}
