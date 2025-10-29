package com.godrej.main.repository;

import java.util.List;

import com.godrej.main.domain.Department;

public interface DepartmentRepository {
	boolean addNewDepartment(Department department);

	Department updateDepartment(Department department);

	Department getDepartmentByDepartmentId(int departmentId);

	List<Department> getAllDepartments();
}
