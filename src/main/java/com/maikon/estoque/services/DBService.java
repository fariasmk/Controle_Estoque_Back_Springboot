package com.maikon.estoque.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maikon.estoque.entities.Movimentacao;
import com.maikon.estoque.entities.Produto;
import com.maikon.estoque.repositories.MovimentacaoRepository;
import com.maikon.estoque.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	public void instanciaBaseDeDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Produto p1 = new Produto(null, "Geladeira", "Eletrodoméstico", 3000.00, 10L);
		Produto p2 = new Produto(null, "Televisão 50 polegadas", "Eletrônico", 4000.00, 15L);
		Produto p3 = new Produto(null, "Mesa", "Móvel", 2000.00, 20L);
		Produto p4 = new Produto(null, "Notebook", "Eletrônico", 5000.00, 5L);



		Movimentacao m1 = new Movimentacao(null, p1, "Entrada", 3000.00, sdf.parse("20/01/2022"), 5L);
		Movimentacao m2 = new Movimentacao(null, p2, "Entrada", 3000.00, sdf.parse("20/01/2022"), 5L);
		Movimentacao m3 = new Movimentacao(null, p1, "Saída", 5000.00, sdf.parse("25/01/2022"), 6L);
		Movimentacao m4 = new Movimentacao(null, p4, "Entrada", 5000.00, sdf.parse("25/01/2022"), 2L);

//		p1.getList().add(m1);
//		p2.getList().add(m2);
//		p1.getList().add(m3);
//		p4.getList().add(m4);
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		movimentacaoRepository.saveAll(Arrays.asList(m1, m2, m3, m4));

	}

}
