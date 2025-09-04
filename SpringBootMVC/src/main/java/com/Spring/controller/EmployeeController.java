package com.Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Spring.entity.Employee;
import com.Spring.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;
	
	public EmployeeController(IEmployeeService empService) {
		this.empService=empService;
	}
	
	@RequestMapping("/home")
	public String showHome() {
		return "home";
	}
	@RequestMapping("/register")
	public String registerEmployee() {
		return "register";
	}
	
	@RequestMapping("/login")
	public String showEmpRegistred(@ModelAttribute Employee employee) {
		empService.saveEmployee(employee);
		return "redirect:/success";
	}
	
	 @GetMapping("/success")
	    public String successPage() {
	        return "success";  // resolves to success.html or success.jsp
	    }
}
