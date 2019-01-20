package com.project.eccomerce.eccomerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration

@EntityScan("com.project.eccomerce.model") 
@EnableJpaRepositories
@ComponentScan("com.project.eccomerce")

@SpringBootApplication
public class EccomerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EccomerceApplication.class, args);
	}

}

