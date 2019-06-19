package br.unisul.pweb.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ParticipacaoPK {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="evento_id")
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name="atleta_id")
	private Atleta atleta;

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result + ((atleta == null) ? 0 : atleta.hashCode());
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
		ParticipacaoPK other = (ParticipacaoPK) obj;
		if(evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (atleta == null) {
			if (other.atleta != null)
				return false;
		} else if (!atleta.equals(other.atleta))
			return false;
		return true;
	}
}
