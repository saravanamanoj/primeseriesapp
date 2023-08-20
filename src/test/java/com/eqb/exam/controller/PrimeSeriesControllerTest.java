package com.eqb.exam.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.eqb.exam.model.Request;
import com.eqb.exam.service.PrimeSeriesService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class PrimeSeriesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MessageSource messageSource;

	@MockBean
	private PrimeSeriesService primeSeriesService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void testGetWelcomeMsg() throws NoSuchMessageException, Exception {
		String expectedMsg= "Spring Boot App to get Prime numbers series lesser than a limit number";
		when(messageSource.getMessage("app.info.msg", null, Locale.getDefault()))
				.thenReturn(expectedMsg);
		mockMvc.perform(get("/apps/primeseries")).andExpect(status().isOk())
				.andExpect(content().string(expectedMsg));
	}
	
	@Test
	public void testGetPrimeSeries() throws NoSuchMessageException, Exception {
		String expectedMsg= "[2,3]";
		Request request = new Request();
		request.setInput(5);
		when(primeSeriesService.getPrimeNumberSeries(5))
				.thenReturn(expectedMsg);
		mockMvc.perform(post("/apps/primeseries")
	            .contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
		.andExpect(status().isOk())
				.andExpect(content().string(expectedMsg));
	}

}
