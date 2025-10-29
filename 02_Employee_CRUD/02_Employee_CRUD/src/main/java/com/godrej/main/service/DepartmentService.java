package com.godrej.main.service;

import java.util.List;

import com.godrej.main.domain.Department;

public interface DepartmentService {
	boolean addNewDepartment(Department department);

	Department getDepartmentByDepartmentId(int departmentId);

	List<Department> getAllDepartments();
}
