package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;
import com.response.ResponseDTO;
import com.services.EmployeeService;

@RestController

@RequestMapping("/api/v2")

public class EmployeeRestController2 {
	@Autowired
	EmployeeService employeeService;
	
	 
	@GetMapping("/employees") //api/v2/employees
	ResponseEntity<List<EmployeeDTO>>findAllEmployees(){
		
		//return employeeService.findAllEmployee();
		
		return new ResponseEntity<>( employeeService.findAllEmployee(),HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/employees/{employeeId}") //localhost:999/api/v2/employees/2
	ResponseEntity<EmployeeDTO> findByEmpId(@PathVariable int employeeId){
		
		EmployeeDTO employeeDTO= employeeService.findByEmployeeId(employeeId);	
		
		if(employeeDTO!=null) {
		
		return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(employeeDTO,HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	@PostMapping("/employees")
	ResponseEntity<String> doRegistration(@RequestBody EmployeeDTO employeeDTO) {

		// System.out.println(employeeEntity);

		employeeService.saveEmployee(employeeDTO);
		
		//return ResponseEntity.ok().body("registration done successfully");
		
		return new ResponseEntity<>("registration done successfully",HttpStatus.CREATED);
		
		
		

	}
	
	

	@PutMapping("/employees")
	ResponseDTO doUpdate(@RequestBody EmployeeDTO employeeDTO) {

		// System.out.println(employeeEntity);

		employeeService.saveEmployee(employeeDTO);
		
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setMessage("updation done successfully");
		responseDTO.setStatus(200);
		return responseDTO;

	}
	
	
	@PutMapping("/employees/{employeeId}")
	ResponseDTO doUpdate2(@RequestBody EmployeeDTO employeeDTO,@PathVariable int employeeId) {

		// System.out.println(employeeEntity);
		employeeDTO.setEmployeeId(employeeId);

		employeeService.saveEmployee(employeeDTO);
		
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setMessage("updation2 done successfully");
		responseDTO.setStatus(200);
		return responseDTO;

	}
	
	
	
	
	
	
	@DeleteMapping("/employees/{employeeId}")   //localhost:999/api/v1/employees/6
	ResponseDTO doDelete(@PathVariable int employeeId) {

		

		employeeService.deleteEmp(employeeId);
		
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setMessage("deletion done successfully");
		responseDTO.setStatus(200);
		return responseDTO;

	}
	

}
