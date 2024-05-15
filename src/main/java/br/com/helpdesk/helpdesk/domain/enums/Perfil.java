package br.com.helpdesk.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Perfil {
	
	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), TECNICO(0, "ENCERRADO");
	
	private Integer codigo;
	
	private String descricao;
	
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Status inválido");
	}

}
