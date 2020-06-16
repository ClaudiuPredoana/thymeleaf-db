package com.predoana.springboot.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.predoana.springboot.thymeleaf.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	//load employee data
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		
		//create employees
		Employee emp1 = new Employee(1, "Laura", "Andre", "laura@gmail.com");
		Employee emp2 = new Employee(2, "Ema", "Berechet", "ema@gmail.com");
		Employee emp3 = new Employee(3, "Arman", "Grigore", "arman@gmail.com");
		
		//create the list
		theEmployees = new ArrayList<>();
		
		//add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
		
	}
	
	//add mapping for "/list"
	
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		
		//add to the string model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
		
	}
}
