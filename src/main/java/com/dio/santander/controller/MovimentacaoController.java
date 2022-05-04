package com.dio.santander.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.dto.NovaMovimentacao;
import com.dio.santander.model.Movimentacao;
import com.dio.santander.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public ResponseEntity<List<Movimentacao>> findAll() {
		try {
			List<Movimentacao> lista = service.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{idConta}")
	public ResponseEntity<List<Movimentacao>> findById (@PathVariable("idConta") Integer idConta){
		try {
			List<Movimentacao> lista = service.findByIdConta(idConta);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody NovaMovimentacao novaMovimentacao) {
		try {
			service.save(novaMovimentacao);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
