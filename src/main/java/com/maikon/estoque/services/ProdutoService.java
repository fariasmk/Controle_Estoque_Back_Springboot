package com.maikon.estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikon.estoque.entities.Movimentacao;
import com.maikon.estoque.entities.Produto;
import com.maikon.estoque.repositories.MovimentacaoRepository;
import com.maikon.estoque.repositories.ProdutoRepository;
import com.maikon.estoque.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private MovimentacaoRepository mRepository;

	public Produto findById(Integer codigo) {
		Optional<Produto> obj = repository.findById(codigo);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Produto não encontrado! Código: " + codigo + ", Tipo: " + Produto.class.getName()));
	}

	public List<Produto> findAll() {
		List<Produto> list = repository.findAll();
		return list;
	}

	public Produto create(Produto obj) {
		obj.setCodigo(null);
		return repository.save(obj);
	}

	public void delete(Integer codigo) {
		repository.deleteById(codigo);
	}

	public Produto update(Integer codigo, Produto obj) {
		Produto newObj = findById(codigo);
		newObj.setDescricao(obj.getDescricao());
		newObj.setTipo(obj.getTipo());
		newObj.setPrecoFornecedor(obj.getPrecoFornecedor());
		newObj.setQtdeEstoque(obj.getQtdeEstoque());
		return repository.save(newObj);
	}

//	public void atualizaQtdeEstoque(Integer id, String tipoMovimentacao, Long qtdeMovimentada, Long qtdeEstoque) {
//		List<Movimentacao> list = mRepository.atualizaQtdeEstoque();
//		for (@SuppressWarnings("unused")
//		Movimentacao m : list) {
//			if (tipoMovimentacao.contains("Saída")) {
//				qtdeEstoque -= qtdeMovimentada;
//			} else if (tipoMovimentacao.contains("Entrada")){
//				qtdeEstoque += qtdeMovimentada;
//			}
//		}
//		Produto produto = new Produto();
//		produto.setQtdeEstoque(qtdeEstoque);
//	}

}
