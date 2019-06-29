package br.unisul.pweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.pweb.domain.Participacao;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Integer>{

}
