package com.maikon.estoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maikon.estoque.entities.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {


	@Query("SELECT obj FROM Movimentacao obj WHERE obj.tipoMovimentacao = 'Entrada' ORDER BY obj.id")
	List<Movimentacao> findAllEntrada();
	
	@Query("SELECT obj FROM Movimentacao obj WHERE obj.tipoMovimentacao = 'Saída' ORDER BY obj.id")
	List<Movimentacao> findAllSaida();
	
	// Query em orm.xml na pasta META-INF em resources.
//	List<Movimentacao> atualizaQtdeEstoque();
}
