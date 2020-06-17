package com.predoana.springboot.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.predoana.springboot.thymeleaf.entity.Employee;
import com.predoana.springboot.thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController (EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//add mapping for "/list"
	
	@GetMapping("/list")
	public String listEmployee(Model theModel) {

		//get employees from database
		List<Employee> theEmployees = employeeService.findAll();

		//add to the string model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
		
	}
}
