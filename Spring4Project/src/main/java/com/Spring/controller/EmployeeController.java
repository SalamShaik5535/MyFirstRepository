package com.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.entity.Employee;
import com.Spring.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/createEmployee", method = RequestMethod.PUT)
	private ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return new ResponseEntity<String>("Employee Created",HttpStatus.CREATED);
		
	}
	

    @GetMapping("/{id}")
    public Employee getStudent(@PathVariable int id) {
        return employeeService.findEmployee(id);
    }

    @GetMapping("/all")
    public List<Employee> getAllStudents() {
        return employeeService.getAllEmployee();
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestParam String email) {
    	employeeService.updateEmployee(id, email);
        return "Student updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
    	employeeService.deleteEmployee(id);
        return "Student deleted successfully!";
    }
}
