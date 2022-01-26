package com.maikon.estoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikon.estoque.entities.Movimentacao;
import com.maikon.estoque.repositories.MovimentacaoRepository;
import com.maikon.estoque.services.exceptions.ObjectNotFoundException;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository repository;

	public Movimentacao findById(Integer id) {
		Optional<Movimentacao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Movimentacao.class.getName()));
	}
	
	public List<Movimentacao> findAll() {
		List<Movimentacao> list = repository.findAll();
		return list;
	}
	
	public Movimentacao create(Movimentacao obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Movimentacao update(Integer id, Movimentacao obj) {
		Movimentacao newObj = findById(id);
		newObj.setProduto(obj.getProduto());
		newObj.setTipoMovimentacao(obj.getTipoMovimentacao());
		newObj.setValorVenda(obj.getValorVenda());
		newObj.setDataVenda(obj.getDataVenda());
		newObj.setQtdeMovimentada(obj.getQtdeMovimentada());
		return repository.save(newObj);
	}

}
