package com.kiaracsmith.lifestyleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class LifestyleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifestyleAppApplication.class, args);
	}

}
