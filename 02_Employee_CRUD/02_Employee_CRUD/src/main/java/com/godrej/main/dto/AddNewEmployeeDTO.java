package com.godrej.main.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddNewEmployeeDTO {
	@NotBlank(message = "Name cannot be blank")
	@Size(min = 2, max = 50, message = "Name should be > 2 and < 50 chars ")
	private String name;

	@Positive(message = "Salary must be > 0")
	@Digits(integer = 10, fraction = 2, message = "Invalid Salary !!")
	private double salary;

	@Positive(message = "DepartmentId should be positive")
	private int departmentId;
}
