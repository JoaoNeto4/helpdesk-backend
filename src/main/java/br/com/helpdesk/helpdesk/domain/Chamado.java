package br.com.helpdesk.helpdesk.domain;

import java.time.LocalDate;

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
public class Chamado {
	
	private Integer id;
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento;
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;
	
	private Tecnico tecnico;
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
