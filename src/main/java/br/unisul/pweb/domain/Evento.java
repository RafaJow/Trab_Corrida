package br.unisul.pweb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Evento {
/* id, data, cidade, nome, categorias(distancia) */
	
	private static final long serialVersionUID = 1L;
	
	@Id //informa ao bd que se trata de uma ID
	@GeneratedValue(strategy=GenerationType.IDENTITY) // informa que é um AUTOINCREMENT
	private Integer id;
	
	
	private String data;
	
	@JsonIgnore
	@OneToMany(mappedBy="evento")
	private List<Participacao> participantes = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="evento")
	private List<Categoria> categorias = new ArrayList<>();
	
	private String cidade;
	
	private String nome;
	
	public Evento() {
		
	}
	
	public Evento(Integer id, String data, String cidade, String nome) {
		super();
		this.id = id;
		this.data = data;
		this.cidade = cidade;
		this.nome = nome;
	}

	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Participacao> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participacao> participantes) {
		this.participantes = participantes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
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
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}



/* 	@JsonIgnore
	@OneToMany
	@JoinTable(name = "EVENTO_CATEGORIA",
		joinColumns = @JoinColumn(name = "evento_id"),
		inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)*/










