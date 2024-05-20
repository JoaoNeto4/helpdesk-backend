package br.com.helpdesk.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpdesk.helpdesk.domain.Cliente;
import br.com.helpdesk.helpdesk.domain.Pessoa;
import br.com.helpdesk.helpdesk.dto.ClienteDTO;
import br.com.helpdesk.helpdesk.repository.ClienteRepository;
import br.com.helpdesk.helpdesk.repository.PessoaRepository;
import br.com.helpdesk.helpdesk.services.exceptions.DataIntegrityViolationException;
import br.com.helpdesk.helpdesk.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id));
	}


	public List<Cliente> findAll() {

		return repository.findAll();
	}


	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Cliente newObj = new Cliente(objDTO);
		return repository.save(newObj);
		
	}


	private void validaPorCpfEEmail(ClienteDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!"); 
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!"); 
		}
		
	}


	public Cliente upddate(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Cliente(objDTO);
		return repository.save(oldObj);
	}


	public void delete(Integer id) {
		Cliente obj = findById(id);
		if(obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Cliente possui ordens de serviço e não pode ser deletado.");
		}
		repository.deleteById(id);
	}
	
}
