package br.com.helpdesk.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helpdesk.helpdesk.domain.Chamado;


public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

	
	
}
