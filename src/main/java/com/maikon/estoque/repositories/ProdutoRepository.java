package com.maikon.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maikon.estoque.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Query("SELECT p FROM Produto p WHERE p.tipo LIKE %:tipo%")
	public Iterable<Produto> searchByNameLike(@Param("tipo") String tipo);

}
