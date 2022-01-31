package com.maikon.estoque.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Movimentacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "codigo")
	private Produto produto;
	public String tipoMovimentacao;
	private Double valorVenda;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVenda;
	private Long qtdeMovimentada;

	public Movimentacao() {
		super();
	}

	public Movimentacao(Integer id, Produto produto, String tipoMovimentacao, Double valorVenda, Date dataVenda,
			Long qtdeMovimentada) {
		super();
		this.id = id;
		this.produto = produto;
		this.tipoMovimentacao = tipoMovimentacao;
		this.valorVenda = valorVenda;
		this.dataVenda = dataVenda;
		this.qtdeMovimentada = qtdeMovimentada;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Long getQtdeMovimentada() {
		return qtdeMovimentada;
	}

	public void setQtdeMovimentada(Long qtdeMovimentada) {
		this.qtdeMovimentada = qtdeMovimentada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
		return Objects.equals(id, other.id);
	}

}
