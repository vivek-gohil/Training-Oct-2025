package com.godrej.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SquareController {

	// http://localhost:8080/square/5
	@GetMapping("square/{number}")
	public int calculateSquare(@PathVariable("number") int number) {
		System.out.println(number);
		return number * number;
	}
}
