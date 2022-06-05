package com.example.springboot.predictage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.springboot.predictage.dto.AgePredictionDto;
import com.example.springboot.predictage.feign.AgePredictionClientService;

@ExtendWith(MockitoExtension.class)
class AgePredictionServiceTest {

	@Mock
	private AgePredictionClientService agePredictionClientService;
	
	@InjectMocks
	private AgePredictionService agePredictionService;
	

	@BeforeEach
	void setUp() throws Exception {
//		MockitoAnnotations.openMocks(this).close();
//		agePredictionClientService= mock(AgePredictionClientService.class);
//		agePredictionService = new AgePredictionService(agePredictionClientService);
	}

	@Test
	void whenPredictAgeByNameCalledWithValidRequest_ItShouldReturnValidAgePredictionDto() {
		 String name = "semih";
		 AgePredictionDto agePredictionDto = AgePredictionDto.builder()				 											 .name("Semih")
				 											 .age(39)
				 											 .count(15724)
				 											 .countryId(null)
				 											 .build();
		 
		 //given(data) - when(method call) -then(assert)- verify
		when(agePredictionClientService.predictAgeByName(name)).thenReturn(agePredictionDto);
		AgePredictionDto result = agePredictionService.predictAgeByName(name);
		
		assertEquals(agePredictionDto, result);
		verify(agePredictionClientService,times(1)).predictAgeByName(name);
	}
	
	@Test
	void whenPredictAgeByNameAndCountryIdWithValidRequest_ItShouldReturnValidAgePredictionDto() {
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
