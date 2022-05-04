package com.dio.santander.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.dto.NovaMovimentacao;
import com.dio.santander.model.Correntista;
import com.dio.santander.model.Movimentacao;
import com.dio.santander.model.MovimentacaoTipo;
import com.dio.santander.repository.CorrentistaRepository;
import com.dio.santander.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public List<Movimentacao> findAll() {
		return repository.findAll();
	}
	
	public void save(NovaMovimentacao novaMovimentacao) {
		Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		Movimentacao movimentacao = new Movimentacao(novaMovimentacao.getDataModel(),
													novaMovimentacao.getDescricao(),
													valor,
													novaMovimentacao.getTipo(), 
													novaMovimentacao.getIdConta());
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		
		repository.save(movimentacao);
	}

}
