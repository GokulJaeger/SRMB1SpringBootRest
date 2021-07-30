package com.org.springrest6.springrest6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Springrest6Application {

	public static void main(String[] args) {
		SpringApplication.run(Springrest6Application.class, args);
	}

}
