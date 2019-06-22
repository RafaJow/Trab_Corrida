package br.unisul.pweb.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class EventoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	
	
}
