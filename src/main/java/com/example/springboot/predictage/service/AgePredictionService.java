package com.example.springboot.predictage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.predictage.dto.AgePredictionDto;
import com.example.springboot.predictage.feign.AgePredictionClientService;

@Service
public class AgePredictionService {

	private final AgePredictionClientService agePredictionClientService;
	
	@Autowired
	public AgePredictionService(AgePredictionClientService agePredictionClientService) {
		this.agePredictionClientService = agePredictionClientService;
	}

	public AgePredictionDto predictAgeByName(String name) {
		return agePredictionClientService.predictAgeByName(name);
	}

	public AgePredictionDto predictAgeByNameAndCountryId(String name, String countryId) {
		return agePredictionClientService.predictAgeByNameAndCountryId(name, countryId);
	}

}
