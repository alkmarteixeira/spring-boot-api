package br.com.bsaccn.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import br.com.bsaccn.api.model.Juridica;

public interface PessoaJuridicaRepository extends JpaRepository<Juridica, Long> {

	@Transactional(readOnly = true)
	Page<Juridica> findByCnpj(String cnpj, Pageable pageable);
}
