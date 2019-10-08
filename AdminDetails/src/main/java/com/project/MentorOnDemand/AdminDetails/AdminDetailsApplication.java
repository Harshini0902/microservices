package com.project.MentorOnDemand.AdminDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AdminDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminDetailsApplication.class, args);
	}

	@Bean

	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}

}


