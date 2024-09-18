package com.example.Agri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgriApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AgriApplication.class, args);
	}

	@Autowired
	DB db;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(db.getData());
	}
}
