package com.example.springboot.predictage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.springboot.predictage.dto.AgePredictionDto;
import com.example.springboot.predictage.feign.AgePredictionClientService;

class AgePredictionServiceTest {

	private AgePredictionService agePredictionService;
	private AgePredictionClientService agePredictionClientService;

	@BeforeEach
	void setUp() throws Exception {
		agePredictionClientService= mock(AgePredictionClientService.class);
		agePredictionService = new AgePredictionService(agePredictionClientService);
	}

	@Test
	void whenPredictAgeByNameCalledWithValidRequest_ItShouldReturnValidAgePredictionDto() {
		 String name = "semih";
		 AgePredictionDto agePredictionDto = AgePredictionDto.builder()
				 											 .name("Semih")
				 											 .age(39)
				 											 .count(15724)
				 											 .countryId(null)
				 											 .build();
		 
		 //given(data) - when(method call) -then(assert)- verify
		when(agePredictionClientService.predictAgeByName(name)).thenReturn(agePredictionDto);
		AgePredictionDto result = agePredictionService.predictAgeByName(name);
		
		assertEquals(agePredictionDto, result);
		verify(agePredictionClientService).predictAgeByName(name);
	}
	
	@Test
	void whenPredictAgeByNameAndCountryIdWithValidRequest_ItShuldReturnValidAgePredictionDto() {
		String name = "semih";
		String countryId = "TR";
		AgePredictionDto agePredictionDto = AgePredictionDto.builder()
				 											 .name("Semih")
				 											 .age(30)
				 											 .count(10874)
				 											 .countryId("TR")
				 											 .build();
		
		//given - when - then -verify
		when(agePredictionClientService.predictAgeByNameAndCountryId(name, countryId)).thenReturn(agePredictionDto);
		AgePredictionDto result = agePredictionService.predictAgeByNameAndCountryId(name, countryId);
		
		assertEquals(agePredictionDto, result);
		verify(agePredictionClientService).predictAgeByNameAndCountryId(name, countryId);
	}

}
