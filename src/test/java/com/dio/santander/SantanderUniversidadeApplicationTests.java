package com.dio.santander;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.dio.santander.dto.NovaMovimentacao;
import com.dio.santander.model.Conta;
import com.dio.santander.model.Correntista;
import com.dio.santander.model.MovimentacaoTipo;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SantanderUniversidadeApplicationTests {
	private final String URL = "/";
	
	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void index() throws Exception {
		mockMvc.perform(get(URL))
			.andExpect(content().string("Olá Mundo"));
	}
	
	@Test
	public void getListCorrentistas() throws Exception {
		mockMvc.perform(get(URL + "correntistas"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void insertCorrentista() throws Exception{
		mockMvc.perform(post(URL + "correntistas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new Correntista("12345678911", "Adailton", new Conta(0.0, 457L))))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void getListMovimentacoes() throws Exception {
		mockMvc.perform(get(URL + "movimentacoes"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void insertMovimentacao() throws Exception {
		mockMvc.perform(post(URL + "movimentacoes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new NovaMovimentacao("Teste", 50D, MovimentacaoTipo.RECEITA, 1, "2022-05-04")))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	
	@Test
	public static String asJsonString(final Object obj) {
		try{
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}

}
