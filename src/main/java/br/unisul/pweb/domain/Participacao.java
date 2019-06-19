package br.unisul.pweb.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Participacao {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ParticipacaoPK id = new ParticipacaoPK();
	

	public Participacao() {
		
	}
	
	public Participacao(Evento evento, Atleta atleta) {
		super();
		id.setEvento(evento);
		id.setAtleta(atleta);
	}
	
	@JsonIgnore
	public Evento getEvento() {
		return id.getEvento();
	}
	
	public void setEvento(Evento evento) {
		id.setEvento(evento);
	}
	
	public void setAtleta(Atleta atleta) {
		id.setAtleta(atleta);
	}
	
	public Atleta getAtleta() {
		return id.getAtleta();
	}
	
	public ParticipacaoPK getId() {
		return id;
	}
	
	public void setId(ParticipacaoPK id) {
		this.id = id;
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
		Participacao other = (Participacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getAtleta().getNome());
		builder.append(getEvento().getNome());
		builder.append("\n");
		return builder.toString();
	}
	
	

	
}















