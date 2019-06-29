package br.unisul.pweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Evento;
import br.unisul.pweb.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repo;
	
	//BUSCAR POR ID
	public Evento find (Integer id) {
		Optional<Evento> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	//INSERIR
	public Evento insert (Evento obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
