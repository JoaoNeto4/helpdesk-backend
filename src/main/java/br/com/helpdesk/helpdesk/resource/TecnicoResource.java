package br.com.helpdesk.helpdesk.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.helpdesk.helpdesk.domain.Tecnico;
import br.com.helpdesk.helpdesk.dto.TecnicoDTO;
import br.com.helpdesk.helpdesk.services.TecnicoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {
	
	@Autowired
	private TecnicoService service;

	
	@GetMapping("/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
		
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
		
	}
	
	@GetMapping()
	public ResponseEntity<List<TecnicoDTO>> findAll(){
		List<Tecnico> list = service.findAll();
		List<TecnicoDTO> listDTO = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO objDTO){
		Tecnico newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<TecnicoDTO> update(@PathVariable Integer id, @Valid @RequestBody TecnicoDTO objDTO){
		Tecnico obj = service.upddate(id, objDTO);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<TecnicoDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
