package com.slama.instadata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class InstadataApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstadataApplication.class, args);
		System.out.println("APP STARTED");
	}

}
