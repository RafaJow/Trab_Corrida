package br.unisul.pweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.pweb.domain.Categoria;
import br.unisul.pweb.domain.Evento;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Categoria obj WHERE obj.evento.id = :eventoId ORDER BY obj.id")
	public List<Categoria> findCategorias(@Param("eventoId") Integer evento_id);
	
	public List<Categoria> findByEvento(Evento evento);
}
