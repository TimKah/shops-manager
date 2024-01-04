package com.study.shopsmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ShopsmanagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopsmanagerApplication.class, args);
	}
}
