package com.Arth.sql_generator_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SqlGeneratorServiceApplication {
	public static void main(String[] args) {
		// Optimize JVM settings for microservice
		System.setProperty("spring.jmx.enabled", "false");
		System.setProperty("spring.main.lazy-initialization", "true");

		SpringApplication app = new SpringApplication(SqlGeneratorServiceApplication.class);

		// Performance optimizations
		app.setLazyInitialization(true);
		app.setRegisterShutdownHook(true);

		app.run(args);
	}
}
