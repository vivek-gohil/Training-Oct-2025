package com.godrej.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godrej.main.domain.Employee;

//http://localhost:8080/employeecrudapi
@RestController
@RequestMapping("employeecrudapi")
public class EmployeeController {

	private List<Employee> employeeList = new ArrayList<Employee>();

	public EmployeeController() {
		employeeList.add(new Employee(101, "Bhupen", 10000));
		employeeList.add(new Employee(102, "Siddhartha", 10000));
		employeeList.add(new Employee(103, "Heer", 10000));
		employeeList.add(new Employee(104, "Kumar", 10000));
		employeeList.add(new Employee(105, "Sudip", 10000));
	}
	
	@DeleteMapping("employees/{employeeId}")
	public boolean deleteEmployee(@PathVariable("employeeId") int employeeId) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId() == employeeId) {
				employeeList.remove(employee);
				return true;
			}
		}
		return false;
	}

	@PutMapping("employees/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		for (Employee existingEmployee : employeeList) {
			if (existingEmployee.getEmployeeId() == employee.getEmployeeId()) {
				existingEmployee.setName(employee.getName());
				existingEmployee.setSalary(employee.getSalary());
				return employee;
			}
		}
		return null;
	}

	// http://localhost:8080/employeecrudapi/employees/employee
	@PostMapping("employees/employee")
	public boolean addNewEmployee(@RequestBody Employee employee) {
		return employeeList.add(employee);
	}

	// http://localhost:8080/employeecrudapi/employees
	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		return employeeList;
	}

	// http://localhost:8080/employeecrudapi/employees/102
	@GetMapping("employees/{employeeId}")
	public Employee getEmployeeByEmployeeId(@PathVariable("employeeId") int employeeId) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId() == employeeId) {
				return employee;
			}
		}
		return null;
	}
}
