package com.godrej.main.repository;

import java.util.List;

import com.godrej.main.domain.Employee;

public interface EmployeeRepository {
	boolean addNewEmployee(Employee employee);

	boolean deleteEmployee(int employeeId);

	Employee getEmployeeByEmployeeId(int employeeId);

	Employee updateEmployee(Employee employee);

	List<Employee> getAllEmployees();
}
