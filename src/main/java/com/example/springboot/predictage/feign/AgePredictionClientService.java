package com.example.springboot.predictage.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.predictage.dto.AgePredictionDto;

@FeignClient(name = "agePredictionClientService", url = "${client.predictage.baseUrl}", configuration = AgePredictionClientServiceConfig.class)
public interface AgePredictionClientService {

	@GetMapping
	public AgePredictionDto predictAgeByName(@RequestParam(name = "name") String name);

	@GetMapping
	public AgePredictionDto predictAgeByNameAndCountryId(@RequestParam(name = "name") String name,
			@RequestParam(name = "country_id") String countryId);
}
