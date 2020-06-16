package com.predoana.springboot.thymeleaf.service;


import com.predoana.springboot.thymeleaf.dao.EmployeeRepository;
import com.predoana.springboot.thymeleaf.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements com.predoana.springboot.thymeleaf.service.EmployeeService {

	private EmployeeRepository emplyeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmplyeeRepository) {
		emplyeeRepository = theEmplyeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return emplyeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = emplyeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			//we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
			
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		emplyeeRepository.save(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {

		emplyeeRepository.deleteById(theId);
	}

}









