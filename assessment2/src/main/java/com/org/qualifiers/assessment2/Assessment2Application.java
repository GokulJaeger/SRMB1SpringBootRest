package com.org.qualifiers.assessment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assessment2Application implements CommandLineRunner {

	@Autowired
    private ProductService prodService;
	public static void main(String[] args) {
		SpringApplication.run(Assessment2Application.class, args);
	}

	@Override
    public void run(String... args) {
        System.out.println(prodService.product());
    }

}
