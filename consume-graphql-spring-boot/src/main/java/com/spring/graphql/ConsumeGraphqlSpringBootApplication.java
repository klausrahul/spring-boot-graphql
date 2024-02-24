package com.spring.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class ConsumeGraphqlSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumeGraphqlSpringBootApplication.class, args);
	}

}
