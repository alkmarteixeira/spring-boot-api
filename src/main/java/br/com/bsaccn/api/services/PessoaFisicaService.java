package br.com.bsaccn.api.services;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.bsaccn.api.model.Pessoa;

public interface PessoaFisicaService {

	/**
	 * Retorna uma pessoa dado um CPF.
	 * 
	 * @param cpf
	 * @return Page<Pessoa>
	 */
	Page<Pessoa> buscarPorCpf(String cpf, Pageable pageRequest);

	/**
	 * Retorna uma pessoa dado i Id.
	 * 
	 * @param id
	 * @return Optional<Pessoa>
	 */
	Optional<Pessoa> buscarPessoaPorId(long id);
}
