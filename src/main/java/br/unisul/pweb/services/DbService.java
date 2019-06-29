package br.unisul.pweb.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.domain.Atleta;
import br.unisul.pweb.domain.Categoria;
import br.unisul.pweb.domain.Evento;
import br.unisul.pweb.domain.Participacao;
import br.unisul.pweb.repository.AtletaRepository;
import br.unisul.pweb.repository.CategoriaRepository;
import br.unisul.pweb.repository.EventoRepository;
import br.unisul.pweb.repository.ParticipacaoRepository;

@Service
public class DbService {

	@Autowired
	private AtletaRepository atletaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private ParticipacaoRepository participacaoRepository;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Atleta atle1 = new Atleta(null, "Joao", 20, 'M', "Equipe1", 15.00);
		Atleta atle2 = new Atleta(null, "Ana", 30, 'F', "Equipe2", 30.00);
		
		Evento eve1 = new Evento(null, "01-01-01", "Tubarao", "Corrida da folha");
		Evento eve2 = new Evento(null, "02-02-02", "Garopaba", "Corrida da areia");
		
		Categoria cat1eve1 = new Categoria(null, 15.00);
		Categoria cat2eve1 = new Categoria(null, 30.00);
		Categoria cat1eve2 = new Categoria(null, 30.00);
		Categoria cat2eve2 = new Categoria(null, 40.00);
		
		eve1.getCategorias().addAll(Arrays.asList(cat1eve1, cat2eve1));
		eve2.getCategorias().addAll(Arrays.asList(cat1eve2, cat2eve2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1eve1,cat2eve1,cat1eve2,cat2eve2));
		eventoRepository.saveAll(Arrays.asList(eve1,eve2));
		atletaRepository.saveAll(Arrays.asList(atle1,atle2));
		
		Participacao part1eve1 = new Participacao(null, eve1, atle1);
		Participacao part2eve1 = new Participacao(null, eve1, atle2);
		Participacao part1eve2 = new Participacao(null, eve2, atle2);
		
		eve1.getParticipantes().addAll(Arrays.asList(part1eve1,part2eve1));
		eve2.getParticipantes().addAll(Arrays.asList(part1eve2));
		
		participacaoRepository.saveAll(Arrays.asList(part1eve1, part2eve1, part1eve2));
		
	}
}
