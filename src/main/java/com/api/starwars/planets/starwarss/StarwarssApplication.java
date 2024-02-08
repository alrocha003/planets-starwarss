package com.api.starwars.planets.starwarss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class StarwarssApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarwarssApplication.class, args);
	}
}
