package br.com.bsaccn.api.services.impl;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.bsaccn.api.model.Pessoa;
import br.com.bsaccn.api.services.PessoaFisicaService;
import br.com.bsaccn.api.repositories.PessoaFisicaRepository;

@Service
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

	private static final Logger log = LoggerFactory.getLogger(PessoaFisicaService.class);

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
	
	@Override
	public Page<Pessoa> buscarPorCpf(String cpf, Pageable pageRequest) {
		log.info("Buscando uma pessoa para o CPF {}", cpf);
		return pessoaFisicaRepository.findByCpf(cpf, pageRequest);
	}

	@Cacheable("buscarPessoaPorId")
	public Optional<Pessoa> buscarPessoaPorId(long id) {
		log.info("Buscando uma pessoa para o ID {}", id);
		return pessoaFisicaRepository.findById(id);
	}
}
