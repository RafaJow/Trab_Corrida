package br.unisul.pweb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Categoria {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Double distancia;
	
	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	public Categoria() {
		
	}
	
	public Categoria(Integer id, Double distancia) {
		super();
		this.id = id;
		this.distancia = distancia;
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	
	public String toString() {
		return this.distancia+"";
	}
}
