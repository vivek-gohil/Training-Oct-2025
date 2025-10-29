package com.godrej.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.godrej.main.domain.Department;

public class DepartmentRowMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		int departmentId = rs.getInt("department_id");
		String departmentName = rs.getString("department_name");

		Department department = new Department(departmentId, departmentName);
		return department;
	}

}
