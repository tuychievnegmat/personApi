package com.personsApi.personApi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class PersonApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonApiApplication.class, args);
	}

}
