package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class UserManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagmentApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(UserManagmentApplication.class);
	}
}
