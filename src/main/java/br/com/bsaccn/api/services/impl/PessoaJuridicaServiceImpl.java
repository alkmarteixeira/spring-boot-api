package br.com.bsaccn.api.services.impl;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.bsaccn.api.model.Juridica;
import br.com.bsaccn.api.repositories.PessoaJuridicaRepository;
import br.com.bsaccn.api.services.PessoaJuridicaService;

@Service
public class PessoaJuridicaServiceImpl implements PessoaJuridicaService {

	private static final Logger log = LoggerFactory.getLogger(PessoaJuridicaService.class);

	@Autowired
	private PessoaJuridicaRepository pessoaJuridicaRepository;
	
	@Override
	public Page<Juridica> buscarPorCnpj(String cnpj, Pageable pageRequest) {
		log.info("Buscando uma pessoa jurídica para o CNPJ {}", cnpj);
		return pessoaJuridicaRepository.findByCnpj(cnpj, pageRequest);
	}

	@Cacheable("buscarPessoaJuridicaPorId")
	public Optional<Juridica> buscarPessoaJuridicaPorId(long id) {
		log.info("Buscando uma pessoa jurídica para o ID {}", id);
		return pessoaJuridicaRepository.findById(id);
	}
}
