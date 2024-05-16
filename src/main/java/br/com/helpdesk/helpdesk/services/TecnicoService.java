package br.com.helpdesk.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpdesk.helpdesk.domain.Tecnico;
import br.com.helpdesk.helpdesk.repository.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repositary;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repositary.findById(id);
		return obj.orElse(null);
	}
}
