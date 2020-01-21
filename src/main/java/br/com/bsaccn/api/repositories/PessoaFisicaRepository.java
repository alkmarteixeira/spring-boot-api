package br.com.bsaccn.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import br.com.bsaccn.api.model.Pessoa;

public interface PessoaFisicaRepository extends JpaRepository<Pessoa, Long> {

	@Transactional(readOnly = true)
	Page<Pessoa> findByCpf(String cpf, Pageable pageable);
}
