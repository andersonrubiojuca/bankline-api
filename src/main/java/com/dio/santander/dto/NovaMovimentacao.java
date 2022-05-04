package com.dio.santander.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.dio.santander.model.MovimentacaoTipo;

public class NovaMovimentacao {
	private String descricao;
	private Double valor;
	private MovimentacaoTipo tipo;
	private Integer idConta;
	private String dataHora;
	
	public NovaMovimentacao() {}
	
	
	public NovaMovimentacao(String descricao, Double valor, MovimentacaoTipo tipo, Integer idConta, String dataHora) {
		this.descricao = descricao;
		this.valor = valor;
		this.tipo = tipo;
		this.idConta = idConta;
		this.dataHora = dataHora;
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


	public String getDataHora() {
		return dataHora;
	}


	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	
	// Forma de retornar a data mesmo no angular estando apenas yyyy-MM-dd
	public LocalDateTime getDataModel() {
		DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate ld = LocalDate.parse(this.dataHora, DATEFORMATTER);
	    LocalDateTime ldt = LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());
	    return ldt;
	}

	
}
