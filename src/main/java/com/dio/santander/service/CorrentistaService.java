package com.dio.santander.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.dto.NovoCorrentista;
import com.dio.santander.model.Conta;
import com.dio.santander.model.Correntista;
import com.dio.santander.repository.CorrentistaRepository;

@Service
public class CorrentistaService {
	
	@Autowired
	private CorrentistaRepository repository;

	private void save(NovoCorrentista novoCorrentista) {
		Conta conta = new Conta(0.0, new Date().getTime());
		
		Correntista correntista = new Correntista(novoCorrentista.getCpf(), novoCorrentista.getNome(), conta);
		
		repository.save(correntista);
	}
}
