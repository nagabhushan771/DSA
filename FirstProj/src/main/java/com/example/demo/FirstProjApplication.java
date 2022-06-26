package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstProjApplication.class, args);
		
		System.out.println("Welcome to Boot");
		
		Alien a = context.getBean(Alien.class);
//		@Autowired
//		Alien a;
		a.show();

	}

}
