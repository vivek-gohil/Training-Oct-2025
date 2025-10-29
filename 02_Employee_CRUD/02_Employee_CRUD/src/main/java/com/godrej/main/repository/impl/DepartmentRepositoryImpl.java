package com.godrej.main.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.godrej.main.domain.Department;
import com.godrej.main.repository.DepartmentRepository;
import com.godrej.main.rowmapper.DepartmentRowMapper;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String INSERT_NEW_DEPARTMENT = "INSERT INTO department_details(department_name) VALUES(?)";
	private static final String SELECT_DEPARTMENT_BY_DEPARTMENT_ID = "SELECT * FROM department_details WHERE department_id=?";
	private static final String SELECT_ALL_DEPARTMENTS = "SELECT * FROM department_details";
	private static final String UPDATE_DEPARTMENT = "UPDATE department_details SET department_name=? WHERE department_id=?";

	@Override
	public boolean addNewDepartment(Department department) {
		int count = jdbcTemplate.update(INSERT_NEW_DEPARTMENT, department.getDepartmentName());
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public Department updateDepartment(Department department) {
		int count = jdbcTemplate.update(UPDATE_DEPARTMENT, department.getDepartmentName(),
				department.getDepartmentId());
		if (count > 0)
			return department;
		return null;
	}

	@Override
	public Department getDepartmentByDepartmentId(int departmentId) {
		return jdbcTemplate.queryForObject(
				SELECT_DEPARTMENT_BY_DEPARTMENT_ID
				, new DepartmentRowMapper()
				, departmentId
		);
	}

	@Override
	public List<Department> getAllDepartments() {
		return jdbcTemplate.query(
				SELECT_ALL_DEPARTMENTS
				, new DepartmentRowMapper()
		);
	}

}
