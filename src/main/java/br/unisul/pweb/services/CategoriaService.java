package br.unisul.pweb.services;

import java.util.List;
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
	
	//UPDATE / ATUALIZAR
	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(Categoria newObj, Categoria obj) {
		newObj.setDistancia(obj.getDistancia());
	}
	
	//DELETAR
	public void delete (Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	//LISTAR TODAS
	public List<Categoria> findAll(){
		return repo.findAll();
	}
}
