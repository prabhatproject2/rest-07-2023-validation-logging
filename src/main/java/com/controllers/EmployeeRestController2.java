package com.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.MyRunner;
import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;
import com.exceptions.InvalidIdException;
import com.exceptions.NoRecordFoundException;
import com.response.ResponseDTO;
import com.services.EmployeeService;

@RestController

@RequestMapping("/api/v2")


public class EmployeeRestController2 {
	private static final Logger logger=LoggerFactory.getLogger(EmployeeRestController2.class);
	@Autowired
	EmployeeService employeeService;
	
	 
	@GetMapping("/employees") //api/v2/employees
	ResponseEntity<List<EmployeeDTO>>findAllEmployees(){
		logger.info("going to call service layer from controller");
		logger.trace("this statement will not run as logging level is DEBUG");
		
		//return employeeService.findAllEmployee();
		
		return new ResponseEntity<>( employeeService.findAllEmployee(),HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/employees/{employeeId}") //localhost:999/api/v2/employees/2
	ResponseEntity<EmployeeDTO> findByEmpId(@PathVariable int employeeId){
		logger.info("going to fetch a particular employee id======"+employeeId);
		logger.debug(" employee id provided is ======"+employeeId);
		if(employeeId<=0) {
			
			throw new InvalidIdException("id can not be 0 or negative");
			
		}
		
		EmployeeDTO employeeDTO= employeeService.findByEmployeeId(employeeId);	
		
		if(employeeDTO!=null) {
		
		return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
		}
		else {
			
			throw new NoRecordFoundException("record does not exist");
			//return new ResponseEntity<>(employeeDTO,HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	@PostMapping("/employees")
	ResponseEntity<String> doRegistration(@Valid @RequestBody EmployeeDTO employeeDTO) {

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
