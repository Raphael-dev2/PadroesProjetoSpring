package com.example.lab_padroes_projeto_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/** Projeto Spring Boot gerado via Spring initializr.
 * 	Os seguinte módulos foram selecionados:
 * -Spring Data JPA
 * -Spring Web
 * -H2 Database
 * -OpenFeign
 */

@EnableFeignClients
@SpringBootApplication
public class LabPadroesProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesProjetoSpringApplication.class, args);
	}

}
