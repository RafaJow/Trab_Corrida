package br.unisul.pweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Categoria;
import br.unisul.pweb.domain.Evento;
import br.unisul.pweb.repository.CategoriaRepository;
import br.unisul.pweb.repository.EventoRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private EventoRepository eventoRepository;
	
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
	
	//ACHAR POR EVENTO
	public List<Categoria> findByEvento(Integer eventoId) {
		return repo.findCategorias(eventoId);
	}
	
	public List<Categoria> search(Integer id, List<Integer> ids){
		List<Evento> evento = eventoRepository.findAllById(ids);
		return repo.findDistinctByIdContainingAndEventoIn(id, evento);
	}
	
	
}
