package br.com.colaboradores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestaoColaboradoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoColaboradoresApplication.class, args);

		System.out.println("API rodando da porta 8080");
	}

}
