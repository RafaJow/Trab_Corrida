package br.unisul.pweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.pweb.domain.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer>{

	@Transactional(readOnly=true)
	public List<Evento> findAllByOrderByNome();
	
	List<Evento> findDistinctByNomeContainingOrderByNome(String nome);
}
