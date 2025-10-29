package com.godrej.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godrej.main.domain.Employee;
import com.godrej.main.dto.AddNewEmployeeDTO;
import com.godrej.main.mapper.EmployeeMapper;
import com.godrej.main.repository.EmployeeRepository;
import com.godrej.main.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public boolean addNewEmployee(AddNewEmployeeDTO addNewEmployeeDTO) {
		// Using mapper we will convert DTO to Domain
		Employee employee = 
				employeeMapper.mapAddNewEmployeeDTOToDomain(
						addNewEmployeeDTO);
		return employeeRepository.addNewEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		return employeeRepository.deleteEmployee(employeeId);
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		return employeeRepository.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}

}
