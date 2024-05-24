package br.com.helpdesk.helpdesk.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.helpdesk.helpdesk.domain.Chamado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChamadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento;
	
	@NotNull(message = "Campo Prioridade é requerido")
	private Integer prioridade;
	
	@NotNull(message = "Campo Status é requerido")
	private Integer status;
	
	@NotNull(message = "Campo Título é requerido")
	private String titulo;
	
	@NotNull(message = "Campo Observações é requerido")
	private String observacoes;
	
	@NotNull(message = "Campo Técnico é requerido")
	private Integer tecnico;
	
	@NotNull(message = "Campo Cliente é requerido")
	private Integer cliente;
	private String nomeTecnico;
	private String nomeCliente;
	
	
	
	public ChamadoDTO(Chamado obj) {
		
		super();
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.prioridade = obj.getId();
		this.status = obj.getStatus().getCodigo();
		this.titulo = obj.getTitulo();
		this.observacoes = obj.getObservacoes();
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
		this.nomeTecnico = obj.getTecnico().getNome();
		this.nomeCliente = obj.getCliente().getNome();
	}
	
	
	
	
}
