package com.godrej.main.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
	private int employeeId;
	private String name;
	private double salary;
	private Department department;

}
