package com.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;
import com.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/") // default page
	String displayRegistrationPage(Model model) {
		 model.addAttribute("employeeDTO", new EmployeeDTO());

		return "registration";

	}

	@PostMapping("/register")
	String doRegistration(@Valid @ModelAttribute EmployeeDTO employeeDTO,BindingResult bindingResult) {		
		
		
		if (bindingResult.hasErrors()) {
	    	return "registration";	
		}
		

		employeeService.saveEmployee(employeeDTO);

		return "registration";

	}
	
	
	@GetMapping("/login") // default page
	String displayLogin() {
		return "login";

	}
	
	@PostMapping("/login")

	String doLogin(@RequestParam String email, @RequestParam String pswd, Model model) {

		EmployeeEntity employeeEntity = employeeService.authenticate(email, pswd);

		if (employeeEntity != null) {

			model.addAttribute("employee", employeeEntity);

			return "congrates";

		} else {
			model.addAttribute("loginMsg", "sorry..plz try again");

			return "login";
		}

	}
	
	@GetMapping("/findAllEmployee")
	String displayAllEmployee(Model model) {
		
		List<EmployeeDTO> employeeEntityList=employeeService.findAllEmployee();
		
		model.addAttribute("listOfEmployee", employeeEntityList);
		

		return "showAll";

	}
	
	@GetMapping("/deleteEmployee")
	String deleteEmployee(@RequestParam int employeeId,Model model) {
		
		employeeService.deleteEmp(employeeId);
		

		return "redirect:findAllEmployee";

	}
	
	@GetMapping("/showEditForm")
	String showEditForm(@RequestParam int employeeId,Model model) {
		
		EmployeeDTO employeeDTO=employeeService.findByEmployeeId(employeeId);
		model.addAttribute("employee", employeeDTO);	
		return "editForm";
	}
	
	@PostMapping("/UpdateEmployee")
	String doUpdate(@ModelAttribute EmployeeDTO employeeDTO) {

		employeeService.updateEmployee(employeeDTO);
		return "redirect:findAllEmployee";

	}

	
	
	
}
