package br.com.bsaccn.api.controller;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javax.swing.text.MaskFormatter;
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
import br.com.bsaccn.api.dtos.PessoaJuridicaDto;
import br.com.bsaccn.api.dtos.PessoaJuridicaSummaryDto;
import br.com.bsaccn.api.model.Juridica;
import br.com.bsaccn.api.response.Response;
import br.com.bsaccn.api.services.PessoaJuridicaService;

@RestController
@RequestMapping("/api/pessoa-juridica")
@CrossOrigin(origins = "*")
public class PessoaJuridicaController {
	
	private static final Logger log = LoggerFactory.getLogger(PessoaJuridicaController.class);
	
	@Autowired
	private PessoaJuridicaService pessoaJuridicaService;	
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public PessoaJuridicaController() {
		
	}
	
	/**
	 * Retorna a listagem de pessoas jurídicas que possuem um CNPJ.
	 * 
	 * @param cnpj
	 * @return ResponseEntity<Response<PessoaJuridicaSummaryDto>>
	 */
	@GetMapping(value = "/list/{cnpj}")
	public ResponseEntity<Response<Page<PessoaJuridicaSummaryDto>>> listarPessoasPorCnpj(
			@PathVariable("cnpj") String cnpj,
			@RequestParam(value = "pag", defaultValue = "0") int pag,
			@RequestParam(value = "ord", defaultValue = "id") String ord,
			@RequestParam(value = "dir", defaultValue = "DESC") String dir) {
		log.info("Buscando pessoas por CNPJ : {}, página: {}", cnpj, pag);
		Response<Page<PessoaJuridicaSummaryDto>> response = new Response<Page<PessoaJuridicaSummaryDto>>();
		Pageable sortedBy = PageRequest.of(pag, this.qtdPorPagina, Sort.by(ord));
		Page<Juridica> pessoasJuridicas = this.pessoaJuridicaService.buscarPorCnpj(cnpj, sortedBy);
		Page<PessoaJuridicaSummaryDto> pessoasJuridicaDto = pessoasJuridicas.map(juridica -> this.converterPessoaJuridicaSummaryDto(juridica));

		response.setData(pessoasJuridicaDto);
		return ResponseEntity.ok(response);
	}

	private PessoaJuridicaSummaryDto converterPessoaJuridicaSummaryDto(Juridica pessoaJuridica) {
		PessoaJuridicaSummaryDto dto = new PessoaJuridicaSummaryDto();
		MaskFormatter mask;
		try {
			mask = new MaskFormatter("###.###.###/####-##");
			mask.setValueContainsLiteralCharacters(false);
			dto.setCnpj(mask.valueToString(pessoaJuridica.getCnpj()));
		} catch (ParseException e) {
			dto.setCnpj(pessoaJuridica.getCnpj());
			e.printStackTrace();
		}
		dto.setId(pessoaJuridica.getId());
		dto.setNome(pessoaJuridica.getNomeFantasia());
		if (pessoaJuridica.getCartorio() != null)
			dto.setNomeCartorio(pessoaJuridica.getCartorio().getNmCartorio());
		return dto;
	}
	
	/**
	 * Retorna uma pessoa jurídica.
	 * 
	 * @param pessoaId
	 * @return ResponseEntity<Response<PessoaJuridicaDto>>
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<PessoaJuridicaDto>> buscarPessoaJuridicaPorId(@PathVariable("id") long id) {
		log.info("Buscando pessoa jurídica por ID : {}", id);
		Response<PessoaJuridicaDto> response = new Response<PessoaJuridicaDto>();
		Optional<Juridica> pessoaJuridica = this.pessoaJuridicaService.buscarPessoaJuridicaPorId(id);
		
		if (!pessoaJuridica.isPresent()) {
			log.info("Pessoa jurídica não encontrada para o ID: {}", id);
			response.getErrors().add("Pessoa jurídica não encontrada para o id " + id);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.converterPessoaJuridicaDto(pessoaJuridica.get()));
		return ResponseEntity.ok(response);
	}

	private PessoaJuridicaDto converterPessoaJuridicaDto(Juridica juridica) {
		PessoaJuridicaDto dto = new PessoaJuridicaDto();
		dto.setId(juridica.getId());
		MaskFormatter mask;
		try {
			mask = new MaskFormatter("###.###.###/####-##");
			mask.setValueContainsLiteralCharacters(false);
			dto.setCnpj(mask.valueToString(juridica.getCnpj()));
		} catch (ParseException e) {
			dto.setCnpj(juridica.getCnpj());
			e.printStackTrace();
		}
		dto.setRazaoSocial(juridica.getRazaoSocial());
		dto.setNomeFantasia(juridica.getNomeFantasia());
		dto.setObservacao(juridica.getObservacao());
		dto.setEmail(juridica.getEmail());
		dto.setNuCelular(juridica.getNuCelular());
		dto.setNuTelefone(juridica.getNuTelefone());
		if (juridica.getData_criacao() != null) {
			String formattedDate = juridica.getData_criacao().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			dto.setDataCriacao(formattedDate);
		}
		if (juridica.getDataRegistro() != null) {
			String formattedDate = juridica.getDataRegistro().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			dto.setDataRegistro(formattedDate);
		}
		if (juridica.getDataAlteracao() != null) {
			String formattedDate = juridica.getDataAlteracao().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			dto.setDataAlteracao(formattedDate);
		}
		
		return dto;
	}

}
