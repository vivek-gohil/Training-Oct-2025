package com.godrej.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godrej.main.domain.Department;
import com.godrej.main.repository.DepartmentRepository;
import com.godrej.main.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public boolean addNewDepartment(Department department) {
		return departmentRepository.addNewDepartment(department);
	}

	@Override
	public Department getDepartmentByDepartmentId(int departmentId) {
		return departmentRepository.getDepartmentByDepartmentId(departmentId);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.getAllDepartments();
	}

}
