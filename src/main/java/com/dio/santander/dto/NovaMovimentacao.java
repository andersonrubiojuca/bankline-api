package com.dio.santander.dto;

import com.dio.santander.model.MovimentacaoTipo;

public class NovaMovimentacao {
	private String descricao;
	private Double valor;
	private MovimentacaoTipo tipo;
	private Integer idConta;
	
	public NovaMovimentacao() {}
	
	
	public NovaMovimentacao(String descricao, Double valor, MovimentacaoTipo tipo, Integer idConta) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.tipo = tipo;
		this.idConta = idConta;
	}



	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public MovimentacaoTipo getTipo() {
		return tipo;
	}
	public void setTipo(MovimentacaoTipo tipo) {
		this.tipo = tipo;
	}
	public Integer getIdConta() {
		return idConta;
	}
	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	
}
