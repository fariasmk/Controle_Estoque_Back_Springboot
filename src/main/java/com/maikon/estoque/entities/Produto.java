package com.maikon.estoque.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer codigo;

	private String descricao;
	private String tipo;
	private Double precoFornecedor;
	private Long qtdeEstoque;

	@JsonIgnore
	@OneToMany(mappedBy = "produto")
	private List<Movimentacao> list = new ArrayList<>();

	public Produto() {
		super();
	}

	public Produto(Integer codigo, String descricao, String tipo, Double precoFornecedor, Long qtdeEstoque) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = tipo;
		this.precoFornecedor = precoFornecedor;
		this.qtdeEstoque = qtdeEstoque;
	}

	public List<Movimentacao> getList() {
		return list;
	}

	public void setList(List<Movimentacao> list) {
		this.list = list;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPrecoFornecedor() {
		return precoFornecedor;
	}

	public void setPrecoFornecedor(Double valorFornecedor) {
		this.precoFornecedor = valorFornecedor;
	}

	public Long getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(Long qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
