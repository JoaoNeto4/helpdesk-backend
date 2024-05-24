package br.com.helpdesk.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.helpdesk.helpdesk.domain.enums.Prioridade;
import br.com.helpdesk.helpdesk.domain.enums.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Chamado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	//id responsabilidade DB 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento;
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;
	
	@ManyToOne
	//@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;
	
	@ManyToOne
	//@JoinColumn(name = "tecnico_id")
	private Cliente cliente;
	

	public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico,
			Cliente cliente) {
		
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.tecnico = tecnico;
		this.cliente = cliente;
	}
	
	

}
