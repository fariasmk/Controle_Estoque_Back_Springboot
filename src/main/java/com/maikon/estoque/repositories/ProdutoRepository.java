package com.maikon.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maikon.estoque.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

//	@Query("SELECT p FROM Produto p WHERE p.tipo LIKE %:tipo%")
//	public Iterable<Produto> searchByNameLike(@Param("tipo") String tipo);

//	@Query(value ="SELECT p.qtdeEstoque,  FROM Produto p INNER JOIN m.tipoMovimentacao FROM Movimentacao m WHERE p.tipo LIKE %:tipo%", nativeQuery = true)
//	public Iterable<Produto> searchByTipo(@Param("tipo") String tipo);

//	@Query(value = "SELECT p, m.qtdeMovimentada FROM Produto p INNER JOIN Movimentacao m on p.codigo = m.codigo and p.tipo LIKE %:tipo%", nativeQuery = true)
//	public Iterable<Produto> searchByTipo(@Param("tipo") String tipo);

//	@Query("SELECT p, m.qtdeMovimentada FROM Produto p INNER JOIN Movimentacao m WHERE p.tipo LIKE %:tipo%")
//	public Iterable<Produto> searchByTipo(@Param("tipo") String tipo);

//	@Query(value ="SELECT p, m.qtdeMovimentada FROM Produto p INNER JOIN Movimentacao m WHERE m.qtdeMovimentada ='Saída' and p.codigo = m.codigo and p.tipo LIKE %:tipo%", nativeQuery = true)
//	public Iterable<Produto> searchByTipo(@Param("tipo") String tipo);

}
