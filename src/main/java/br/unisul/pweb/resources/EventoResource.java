package br.unisul.pweb.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.pweb.domain.Evento;
import br.unisul.pweb.dtos.EventoDTO;
import br.unisul.pweb.resources.utils.URL;
import br.unisul.pweb.services.AtletaService;
import br.unisul.pweb.services.EventoService;

@RestController
@RequestMapping(value="/eventos")
public class EventoResource {

	@Autowired
	private EventoService service;
	
	@Autowired
	private AtletaService atletaService;
	
	//BUSCAR POR ID
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Evento> find(@PathVariable Integer id){
		Evento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//INSERIR
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Evento obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//EXCLUIR
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//ATUALIZAR
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Evento obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
		
	
	//FILTRAR POR NOME
	@RequestMapping(value="/filtro",method=RequestMethod.GET)
	public ResponseEntity<List<EventoDTO>> filtrarPorNome(
		@RequestParam(value = "nome", defaultValue = "") String nome
		){
		String nomeDecoded = URL.decodeParam(nome);
		List<Evento> lista = service.buscaPorNome(nomeDecoded);
		List<EventoDTO> listaDTO = lista.stream().map(obj -> new EventoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	//LISTAR TODOS
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EventoDTO>> findAll() {
		List<Evento> lista = service.findAll();
		List<EventoDTO> listaDTO = new ArrayList<EventoDTO>();
		for (Evento e : lista) {
			listaDTO.add(new EventoDTO(e));
		}
		return ResponseEntity.ok().body(listaDTO);
	}
	
	
	/*
	//LISTAR ATLETAS DE UM EVENTO
	@RequestMapping(value="/{eventoId}/atletas", method=RequestMethod.GET)
	public ResponseEntity<List<AtletaDTO>> findAtletas(@PathVariable Integer eventoId){
		List<Atleta> list = atletaService.findByEvento(eventoId);
		List<AtletaDTO> listDto = list.stream().map(obj -> new AtletaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}		
	*/
}
