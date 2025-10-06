package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.EmployeeDTO;
import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/select")
	public ResponseEntity<List<EmployeeDTO>> selectAllEmployee(){
		return ResponseEntity.ok(employeeService.selectAllEmployee());
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createEmployee(@RequestBody Employee emp){
		employeeService.createEmployee(emp);
	return ResponseEntity.ok("Employee Created");
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable int id){
		return ResponseEntity.ok(employeeService.findEmployee(id));
	}
}
