package br.com.helpdesk.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpdesk.helpdesk.domain.Chamado;
import br.com.helpdesk.helpdesk.domain.Cliente;
import br.com.helpdesk.helpdesk.domain.Tecnico;
import br.com.helpdesk.helpdesk.domain.enums.Perfil;
import br.com.helpdesk.helpdesk.domain.enums.Prioridade;
import br.com.helpdesk.helpdesk.domain.enums.Status;
import br.com.helpdesk.helpdesk.repository.ChamadoRepository;
import br.com.helpdesk.helpdesk.repository.ClienteRepository;
import br.com.helpdesk.helpdesk.repository.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

		
		
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Joao Neto", "08874165822", "joao@joao.com", "123456");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus", "88888844411", "linus@linus", "123456");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	}

}
