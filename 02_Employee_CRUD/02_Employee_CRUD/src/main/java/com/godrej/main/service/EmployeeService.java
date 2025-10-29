package com.godrej.main.service;

import java.util.List;

import com.godrej.main.domain.Employee;
import com.godrej.main.dto.AddNewEmployeeDTO;

public interface EmployeeService {
	boolean addNewEmployee(AddNewEmployeeDTO addNewEmployeeDTO);

	boolean deleteEmployee(int employeeId);

	Employee getEmployeeByEmployeeId(int employeeId);

	Employee updateEmployee(Employee employee);

	List<Employee> getAllEmployees();
}
