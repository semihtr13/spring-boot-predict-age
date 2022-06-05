package com.example.springboot.predictage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AgePredictionDto {
	private String name;
	private Integer age;
	private Integer count;
	@JsonProperty("country_id")
	private String countryId;
}
