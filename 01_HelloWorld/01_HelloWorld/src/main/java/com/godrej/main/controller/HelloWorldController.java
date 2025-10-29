package com.godrej.main.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	public HelloWorldController() {
		System.out.println("HelloWorldController object created");
	}

	@DeleteMapping("test")
	public String deleteRequest() {
		return "This is delete method test";
	}

	@PutMapping("test")
	public String putRequest() {
		return "This is put method test";
	}

	// http://localhost:8080/show - Post
	@PostMapping("test")
	public String postRequest() {
		return "This is post method test";
	}

	// http://localhost:8080/greet - Get
	// @RequestMapping(value = "greet", method = RequestMethod.GET)
	@GetMapping("test")
	public String greet() {
		return "Hello World - Spring Boot - Devtools Test";
	}
}
