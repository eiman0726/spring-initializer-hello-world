package com.example.springinitializerhelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringInitializerHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringInitializerHelloWorldApplication.class, args);
	}

}
