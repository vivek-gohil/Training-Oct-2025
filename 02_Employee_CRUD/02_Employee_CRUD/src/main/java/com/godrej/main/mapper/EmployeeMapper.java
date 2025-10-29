package com.godrej.main.mapper;

import org.springframework.stereotype.Component;

import com.godrej.main.domain.Department;
import com.godrej.main.domain.Employee;
import com.godrej.main.dto.AddNewEmployeeDTO;

@Component
public class EmployeeMapper {
	public Employee mapAddNewEmployeeDTOToDomain(
				AddNewEmployeeDTO addNewEmployeeDTO) {
		return new Employee(
					0
					, addNewEmployeeDTO.getName()
					, addNewEmployeeDTO.getSalary()
					, new Department(
							addNewEmployeeDTO.getDepartmentId()
							, null
						)
					);
	}
}
