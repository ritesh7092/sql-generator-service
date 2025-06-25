package com.Arth.sql_generator_service;

import org.springframework.boot.SpringApplication;

public class TestSqlGeneratorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(SqlGeneratorServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
