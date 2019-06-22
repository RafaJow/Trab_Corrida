package br.unisul.pweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Atleta;
import br.unisul.pweb.repository.AtletaRepository;

@Service
public class AtletaService {
	
	@Autowired
	private AtletaRepository repo;
	
	//BUSCAR POR ID
	public Atleta find(Integer id) {
		Optional<Atleta> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	//UPDATE / ATUALIZAR
	public Atleta update(Atleta obj) {
		Atleta newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(Atleta newObj, Atleta obj) {
		newObj.setNome(obj.getNome());
		newObj.setIdade(obj.getIdade());
		newObj.setSexo(obj.getSexo());
		newObj.setEquipe(obj.getEquipe());
		newObj.setDistancia(obj.getDistancia());
		
	}
	
	//BUSCAR POR NOME
	public List<Atleta> buscaPorNome(String nome){
		return repo.findDistinctByNomeContainingOrderByNome(nome);
	}
	
}
