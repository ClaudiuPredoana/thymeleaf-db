package com.predoana.springboot.thymeleaf.dao;

import com.predoana.springboot.thymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
