package com.example.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import com.example.springsboot.SpringsbootApplication;

@SpringBootApplication(scanBasePackages = "com.example.controller")
@EntityScan(basePackages="com.example.entity")
@EnableJpaRepositories(basePackages="com.example.repository")
@EnableWebMvc

public class RestaurantApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplicationTests.class, args);
	}

}

