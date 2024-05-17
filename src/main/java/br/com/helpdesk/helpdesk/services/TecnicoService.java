package br.com.helpdesk.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpdesk.helpdesk.domain.Tecnico;
import br.com.helpdesk.helpdesk.dto.TecnicoDTO;
import br.com.helpdesk.helpdesk.repository.TecnicoRepository;
import br.com.helpdesk.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repositary;
	
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repositary.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id));
	}


	public List<Tecnico> findAll() {

		return repositary.findAll();
	}


	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		Tecnico newObj = new Tecnico(objDTO);
		return repositary.save(newObj);
		
	}
}
