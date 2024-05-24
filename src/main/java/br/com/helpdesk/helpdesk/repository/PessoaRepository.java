package br.com.helpdesk.helpdesk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helpdesk.helpdesk.domain.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

	Optional<Pessoa> findByCpf(String cpf);
	//UserDetails findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);
	//UserDetails findByEmail(String email);
	
}
