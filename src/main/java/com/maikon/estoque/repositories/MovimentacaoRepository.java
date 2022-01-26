package com.maikon.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maikon.estoque.entities.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
	

	
}
