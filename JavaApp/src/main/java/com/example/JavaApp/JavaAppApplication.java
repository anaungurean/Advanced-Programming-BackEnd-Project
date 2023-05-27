package com.example.JavaApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@OpenAPIDefinition
@Configuration
@ComponentScan(basePackages = {"com.example.JavaApp","com.example.JavaApp.User","com.example.JavaApp.Subject"})


public class JavaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaAppApplication.class, args);
	}

}
