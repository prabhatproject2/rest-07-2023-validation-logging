package com.services;

import java.util.List;

import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;

public interface EmployeeService {

	void saveEmployee(EmployeeDTO employeeDTO);

	EmployeeEntity authenticate(String email, String pswd);

	List<EmployeeDTO> findAllEmployee();

	void deleteEmp(int employeeId);

	EmployeeDTO findByEmployeeId(int employeeId);

	void updateEmployee(EmployeeDTO employeeDTO);




}
