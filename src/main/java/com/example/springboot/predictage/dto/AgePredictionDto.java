package com.example.springboot.predictage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AgePredictionDto {
	private String name;
	private Integer age;
	private Integer count;
	@JsonProperty("country_id")
	private String countryId;
}
