package com.godrej.main.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.godrej.main.domain.Employee;
import com.godrej.main.exception.ResourceNotFoundException;
import com.godrej.main.repository.EmployeeRepository;
import com.godrej.main.rowmapper.EmployeeRowMapper;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String INSERT_NEW_EMPLOYEE = "INSERT INTO employee_details(name,salary,department_id) VALUES(?,?,?)";
	private static final String UPDATE_EMPLOYEE = "UPDATE employee_details SET name=?,salary=?,department_id=? WHERE employee_id=?";
	private static final String SELECT_EMPLOYEE_BY_EMPLOYEE_ID = "SELECT e.employee_id,e.name,e.salary,d.department_id,d.department_name FROM employee_details e JOIN department_details d ON e.department_id = d.department_id WHERE employee_id=?";
	private static final String SELECT_ALL_EMPLOYEES = "SELECT e.employee_id,e.name,e.salary,d.department_id,d.department_name FROM employee_details e JOIN department_details d ON e.department_id = d.department_id";
	private static final String DELETE_EMPLOYEE_BY_EMPLOYEE_ID = "DELETE FROM employee_details WHERE employee_id=?";

	@Override
	public boolean addNewEmployee(Employee employee) {
		int count = jdbcTemplate.update(INSERT_NEW_EMPLOYEE, employee.getName(), employee.getSalary(),
				employee.getDepartment().getDepartmentId());
		return (count > 0) ? true : false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		int count = jdbcTemplate.update(DELETE_EMPLOYEE_BY_EMPLOYEE_ID, employeeId);
		return (count > 0) ? true : false;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		try {
			return jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BY_EMPLOYEE_ID, new EmployeeRowMapper(), employeeId);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(
					"Employee"
					, "employeeId"
					, String.valueOf(employeeId));
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		int count = jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getName(), employee.getSalary(),
				employee.getDepartment().getDepartmentId(), employee.getEmployeeId());
		return (count > 0) ? employee : null;

	}

	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(SELECT_ALL_EMPLOYEES, new EmployeeRowMapper());
	}

}
