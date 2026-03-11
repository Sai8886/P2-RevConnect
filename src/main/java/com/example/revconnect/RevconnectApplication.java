package com.example.revconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RevconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevconnectApplication.class, args);
		System.out.println(System.getProperty("spring.datasource.url"));
	}

}
