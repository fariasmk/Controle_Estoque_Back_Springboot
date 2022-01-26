package com.maikon.estoque;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstoqueApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

	}

}
