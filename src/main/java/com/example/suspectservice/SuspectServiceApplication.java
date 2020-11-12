package com.example.suspectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.suspectservice")
@ComponentScan(basePackages = { "com.example.suspectservice" })
@EntityScan("com.example.suspectservice") 
public class SuspectServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SuspectServiceApplication.class, args);
	}
}
