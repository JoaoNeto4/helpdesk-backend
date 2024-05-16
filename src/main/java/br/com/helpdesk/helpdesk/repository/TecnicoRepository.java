package br.com.helpdesk.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helpdesk.helpdesk.domain.Tecnico;


public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

	
	
}
