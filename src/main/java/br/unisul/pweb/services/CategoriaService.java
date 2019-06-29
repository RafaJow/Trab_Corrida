package br.unisul.pweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Categoria;
import br.unisul.pweb.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	//BUSCAR POR ID
	public Categoria find (Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	//INSERIR
	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	
}
