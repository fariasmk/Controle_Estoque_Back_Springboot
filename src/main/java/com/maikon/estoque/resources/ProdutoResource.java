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

import com.maikon.estoque.entities.Produto;
import com.maikon.estoque.services.ProdutoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

//	@Autowired
//	private ProdutoRepository produtoRepository;

	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Produto> findById(@PathVariable Integer codigo) {
		Produto obj = service.findById(codigo);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Produto>> listAll() {
		List<Produto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

//	@GetMapping(path = "/tipo/{tipo}")
//	public Iterable<Produto> obterProdutosPorTipo(@PathVariable String tipo) {
//		return produtoRepository.searchByTipo(tipo);
//	}

	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody Produto obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(obj.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Void> delete(@PathVariable Integer codigo) {
		service.delete(codigo);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{codigo}")
	public ResponseEntity<Produto> update(@PathVariable Integer codigo, @RequestBody Produto obj) {
		Produto newObj = service.update(codigo, obj);
		return ResponseEntity.ok().body(newObj);
	}
}
