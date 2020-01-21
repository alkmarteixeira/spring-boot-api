package br.com.bsaccn.api.services;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.com.bsaccn.api.model.Juridica;

public interface PessoaJuridicaService {

	/**
	 * Retorna uma pessoa jurídica dado um CNPJ.
	 * 
	 * @param cnpj
	 * @return Page<Juridica>
	 */
	Page<Juridica> buscarPorCnpj(String cnpj, Pageable pageRequest);

	/**
	 * Retorna uma pessoa jurídica dado Id.
	 * 
	 * @param id
	 * @return Optional<Juridica>
	 */
	Optional<Juridica> buscarPessoaJuridicaPorId(long id);
}
