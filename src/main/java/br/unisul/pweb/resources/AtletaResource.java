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

import br.unisul.pweb.domain.Atleta;
import br.unisul.pweb.dtos.AtletaDTO;
import br.unisul.pweb.resources.utils.URL;
import br.unisul.pweb.services.AtletaService;

@RestController
@RequestMapping(value="/atletas")
public class AtletaResource {

	@Autowired
	private AtletaService service;
	
	//BUSCAR POR ID
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Atleta> find(@PathVariable Integer id){
		Atleta obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//INSERIR
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Atleta obj){
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
	public ResponseEntity<Void> update(@RequestBody Atleta obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	//FILTRAR POR NOME
	@RequestMapping(value="/filtro",method=RequestMethod.GET)
	public ResponseEntity<List<AtletaDTO>> filtrarPorNome(
			@RequestParam(value = "nome", defaultValue = "") String nome
		){
		String nomeDecoded = URL.decodeParam(nome);
		List<Atleta> lista = service.buscaPorNome(nomeDecoded);
		List<AtletaDTO> listaDTO = lista.stream().map(obj -> new AtletaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	//LISTAR TODOS
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AtletaDTO>> findAll() {
		List<Atleta> lista = service.findAll();
		List<AtletaDTO> listaDTO = new ArrayList<AtletaDTO>();
		for (Atleta a : lista) {
			listaDTO.add(new AtletaDTO(a));
		}
		return ResponseEntity.ok().body(listaDTO);
	}
}
