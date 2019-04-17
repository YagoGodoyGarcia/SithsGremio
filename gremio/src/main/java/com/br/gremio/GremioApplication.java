package com.br.gremio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Yago Garcia
 */
@SpringBootApplication
@EnableJpaRepositories("com.br.gremio.repository")
public class GremioApplication {
	public static void main(String[] args) {
		SpringApplication.run(GremioApplication.class, args);
	}
}
