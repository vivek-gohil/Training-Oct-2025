package com.godrej.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.godrej.main.domain.Department;
import com.godrej.main.domain.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		int employeeId = rs.getInt("employee_id");
		String name = rs.getString("name");
		double salary = rs.getDouble("salary");

		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setName(name);
		employee.setSalary(salary);

		int departmentId = rs.getInt("department_id");
		String departmentName = rs.getString("department_name");

		Department department = new Department();
		department.setDepartmentId(departmentId);
		department.setDepartmentName(departmentName);

		employee.setDepartment(department);

		return employee;

	}

}
