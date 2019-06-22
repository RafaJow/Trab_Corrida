package br.unisul.pweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.pweb.domain.Atleta;

public interface AtletaRepository extends JpaRepository<Atleta, Integer>{

	@Transactional(readOnly=true)
	public List<Atleta> findAllByOrderByNome();
	
	List<Atleta> findDistinctByNomeContainingOrderByNome(String nome;)
}
