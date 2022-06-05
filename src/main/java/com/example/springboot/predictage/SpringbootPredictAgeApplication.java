package com.example.springboot.predictage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootPredictAgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPredictAgeApplication.class, args);
	}

}
