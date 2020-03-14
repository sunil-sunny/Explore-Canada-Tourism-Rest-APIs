package com.ExploreCanada.packages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.ExploreCanada")
public class PackagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackagesApplication.class, args);
	}

}
