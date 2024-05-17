package br.com.helpdesk.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.helpdesk.helpdesk.domain.enums.Perfil;
import br.com.helpdesk.helpdesk.dto.TecnicoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tecnico extends Pessoa{

	private static final long serialVersionUID = 1L;
	

	@JsonBackReference
	@OneToMany(mappedBy = "tecnico")
	private List<Chamado> chamados = new ArrayList<>();
	
	
	public Tecnico() {
		super();
		addPerfil(Perfil.CLIENTE);
	}
	
	public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		addPerfil(Perfil.CLIENTE);
	}
	
	public Tecnico(TecnicoDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis()
					.stream().map(x -> x.getCodigo()).
					collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();

	}
	
}
