package br.unisul.pweb.services;

import java.util.List;
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
	
	
	//DELETAR
	public void delete (Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	//UPDATE / ATUALIZAR
	public Evento update(Evento obj) {
		Evento newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(Evento newObj, Evento obj) {
		newObj.setData(obj.getData());
		newObj.setCidade(obj.getCidade());
		newObj.setCategorias(obj.getCategorias());
		newObj.setNome(obj.getNome());
		newObj.setData(obj.getData());
	}
	
	//BUSCAR POR NOME
	public List<Evento> buscaPorNome(String nome){
		return repo.findDistinctByNomeContainingOrderByNome(nome);
	}
		
	//LISTAR TODAS
	public List<Evento> findAll(){
		return repo.findAll();
	}	
}
