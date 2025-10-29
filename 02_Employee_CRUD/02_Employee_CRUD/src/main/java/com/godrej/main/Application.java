package com.godrej.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.godrej.main.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j // lombok is doing configuration for slf5j logger
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Spring boot application started!!");
	}

}
