package com.godrej.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godrej.main.domain.Employee;
import com.godrej.main.dto.AddNewEmployeeDTO;
import com.godrej.main.service.EmployeeService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("employeecrudapi")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("employees/{employeeId}")
	public Employee getEmployeeByEmployeeId(@PathVariable("employeeId") int employeeId) {
		return employeeService.getEmployeeByEmployeeId(employeeId);
	}

	@PostMapping("employees/employee")
	public boolean addNewEmployee(@Valid @RequestBody AddNewEmployeeDTO addNewEmployeeDTO) {
		return employeeService.addNewEmployee(addNewEmployeeDTO);
	}

	@PutMapping("employees/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("employees/{employeeId}")
	public boolean deleteEmployeeeByEmployeeId(@PathVariable("employeeId") int employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
}
