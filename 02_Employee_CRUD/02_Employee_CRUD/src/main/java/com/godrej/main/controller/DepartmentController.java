package com.godrej.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godrej.main.domain.Department;
import com.godrej.main.service.DepartmentService;

@RestController
@RequestMapping("departmentcrudapi")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@GetMapping("departments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("departments/{departmentId}")
	public Department getSingleDepartment(@PathVariable("departmentId") int departmentId) {
		return departmentService.getDepartmentByDepartmentId(departmentId);
	}

	@PostMapping("departments/department")
	public boolean addNewDepartment(@RequestBody Department department) {
		return departmentService.addNewDepartment(department);
	}

}
