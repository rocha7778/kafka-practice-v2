package com.rocha.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ProductCommandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCommandServiceApplication.class, args);
	}

}
