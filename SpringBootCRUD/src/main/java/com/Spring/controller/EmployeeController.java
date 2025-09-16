package com.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.entity.Employee;
import com.Spring.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	public EmployeeController(EmployeeService empService) {
		this.empService=empService;
	}
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empService.save(employee);
	}
	
	@GetMapping("/find")
	public List<Employee> getAllEmployees(){
		return empService.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return empService.findById(id);
	}
	
	@PutMapping("/updateEmp/{id}")
	public Employee updateEmployee(@PathVariable int id,Employee employee) {
		return empService.update(id, employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		 empService.delete(id);
		 return "Employee With ID "+id+" Deleted";
	}
	
	@PostMapping("/page")
	public Page<Employee> findEmp(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue ="5") int size,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String order){
		
		 	Sort.Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
	        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

				return empService.findAllEmp(pageable);
		
	}
}
