package br.com.helpdesk.helpdesk.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.helpdesk.helpdesk.domain.Tecnico;
import br.com.helpdesk.helpdesk.domain.enums.Perfil;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TecnicoDTO implements Serializable{

	@JsonIgnore
	private static final long serialVersionUID = 1L;
	
	

	protected Integer id;
	
	@NotNull(message = "Campo Nome é requirido!")
	protected String nome;
	
	@NotNull(message = "Campo CPF é requirido!")
	protected String cpf;
	
	@NotNull(message = "Campo Email é requirido!")
	protected String email;
	
	@NotNull(message = "Campo Senha é requirido!")
	protected String senha;
	protected Set<Integer> perfis = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	
	
	public TecnicoDTO() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	
	public TecnicoDTO(Tecnico obj) {
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
		
		addPerfil(Perfil.CLIENTE);

	}
	
	
	public Set<Perfil> getPerfis(){
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}



}
