package br.unisul.pweb.dtos;

import java.io.Serializable;

import br.unisul.pweb.domain.Categoria;

public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private double distancia;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria c) {
		this.id = c.getId();
		this.distancia = c.getDistancia();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaDTO other = (CategoriaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	*/
}
