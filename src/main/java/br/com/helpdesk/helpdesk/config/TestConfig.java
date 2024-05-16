package br.com.helpdesk.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.helpdesk.helpdesk.services.DBService;
import jakarta.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	
	@PostConstruct
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}

}
