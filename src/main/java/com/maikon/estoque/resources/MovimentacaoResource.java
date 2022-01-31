package com.maikon.estoque.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maikon.estoque.entities.Movimentacao;
import com.maikon.estoque.services.MovimentacaoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/movimentacao")
public class MovimentacaoResource {

	@Autowired
	private MovimentacaoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Movimentacao> findById(@PathVariable Integer id) {
		Movimentacao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/entrada")
	public ResponseEntity<List<Movimentacao>> listOpen() {
		List<Movimentacao> list = service.findAllEntrada();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/saida")
	public ResponseEntity<List<Movimentacao>> listClose() {
		List<Movimentacao> list = service.findAllSaida();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<List<Movimentacao>> listAll() {
		List<Movimentacao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Movimentacao> create(@RequestBody Movimentacao obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Movimentacao> update(@PathVariable Integer id, @RequestBody Movimentacao obj) {
		Movimentacao newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

}
