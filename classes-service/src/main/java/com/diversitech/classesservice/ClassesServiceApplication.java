package com.diversitech.classesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.diversitech.classesservice.repository")

public class ClassesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassesServiceApplication.class, args);
	}

}
