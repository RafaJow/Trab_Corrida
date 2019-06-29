package br.unisul.pweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.pweb.domain.Atleta;
import br.unisul.pweb.domain.Evento;

public interface AtletaRepository extends JpaRepository<Atleta, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Atleta obj WHERE obj.evento.id = :eventoId ORDER BY obj.nome")
	public List<Atleta> findAtletas(@Param("eventoId") Integer evento_id);
	
	public List<Atleta> findAllByOrderByNome();
	
	List<Atleta> findDistinctByNomeContainingOrderByNome(String nome);
	
	List<Atleta> findDistinctByNomeContainingAndEventoIn(String nome, List<Evento> evento);
}
