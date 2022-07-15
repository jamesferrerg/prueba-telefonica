package com.test.telefonica.cuadratica.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.test.telefonica.controller.Operacion;
import com.test.telefonica.services.IEjercicioService;

@WebMvcTest(Operacion.class)
public class OperacionTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IEjercicioService ejercicioService;
	
	@Test
	public void cuadratica() throws Exception {
		
		when(ejercicioService.cuadratica(2, 7, 2)).thenReturn("[-0.31385933836549285, -3.186140661634507]");
		
		mvc.perform(get("/api/cuadratica").contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")));
		
		verify(ejercicioService).cuadratica(2, 7, 2);
		
	}

}
