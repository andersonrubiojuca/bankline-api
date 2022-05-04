package com.dio.santander;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

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

}
