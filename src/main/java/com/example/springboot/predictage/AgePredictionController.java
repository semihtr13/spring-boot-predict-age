package com.example.springboot.predictage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.predictage.dto.AgePredictionDto;
import com.example.springboot.predictage.service.AgePredictionService;

@RestController
public class AgePredictionController {

	private static final String HEADER_X_RATE_LIMIT_LIMIT_NAME = "X-Rate-Limit-Limit";
	private static final Integer HEADER_X_RATE_LIMIT_LIMIT_VALUE = 1000;
	private static final String HEADER_X_RATE_LIMIT_REMAINING_NAME = "X-Rate-Limit-Remaining";
	private static final Integer HEADER_X_RATE_LIMIT_REMAINING_VALUE = 750;
	private static final String HEADER_X_RATE_RESET_NAME = "X-Rate-Reset-Name";
	private static final Integer HEADER_X_RATE_RESET_VALUE = 1528;

	@Autowired
	private AgePredictionService agePredictionService;

	@GetMapping
	public ResponseEntity<AgePredictionDto> predictAgeByNameAndCountryId(@RequestParam(name = "name") String name,
			@RequestParam(name = "countryId", required = false) String countryId) {
		if (StringUtils.isEmpty(countryId)) {
			HttpHeaders httpHeaders = getCustomHttpHeaders();
			return ResponseEntity.ok()
								.headers(httpHeaders)
								.body(agePredictionService.predictAgeByName(name));
		}
		HttpHeaders httpHeaders = getCustomHttpHeaders();
		return ResponseEntity.ok()
							 .headers(httpHeaders)
							 .body(agePredictionService.predictAgeByNameAndCountryId(name, countryId));
	}

	private HttpHeaders getCustomHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set(HEADER_X_RATE_LIMIT_LIMIT_NAME, HEADER_X_RATE_LIMIT_LIMIT_VALUE.toString());
		httpHeaders.set(HEADER_X_RATE_LIMIT_REMAINING_NAME, HEADER_X_RATE_LIMIT_REMAINING_VALUE.toString());
		httpHeaders.set(HEADER_X_RATE_RESET_NAME, HEADER_X_RATE_RESET_VALUE.toString());
		return httpHeaders;
	}

}
