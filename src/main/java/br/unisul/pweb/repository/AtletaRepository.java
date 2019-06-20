package br.unisul.pweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisul.pweb.domain.Atleta;

public interface AtletaRepository extends JpaRepository<Atleta, Integer>{

	
}
