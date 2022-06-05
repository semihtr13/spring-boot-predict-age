package com.example.springboot.predictage.feign;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;

import feign.Feign;
import feign.Logger;
import feign.Request.Options;

public class AgePredictionClientServiceConfig {
	
	@Bean
	public Feign feign() {
		return Feign.builder()
				.logLevel(Logger.Level.FULL)
				.options(new Options(120, TimeUnit.SECONDS,60, TimeUnit.SECONDS, false))
				.build();
	}

}
