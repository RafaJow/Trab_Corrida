package br.unisul.pweb.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Evento {
/* id, data, cidade, nome, categorias(distancia) */
	
	private static final long serialVersionUID = 1L;
	
	@Id //informa ao bd que se trata de uma ID
	@GeneratedValue(strategy=GenerationType.IDENTITY) // informa que é um AUTOINCREMENT
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
}
