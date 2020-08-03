package com.sky.service.parental.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParentalControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnTrue_whenMovieIsPermissible() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/pc/movie/beta/rating/PG").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("true")));
	}

	@Test
	public void shouldReturnFalse_whenMovieIsImpermissible() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/pc/movie/echo/rating/U").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("false")));
	}

	@Test
	public void shouldReturnSystemError_whenThereIsATechnicalFailure() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/pc/movie/foxtrot/rating/U").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError())
				.andExpect(status().reason("System error, customer cannot watch this movie"));
	}

	@Test
	public void shouldReturnNotFoundError_whenMovieNotFound() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/pc/movie/idontexist/rating/U").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andExpect(status().reason("The movie service could not find the given movie"));
	}
}
