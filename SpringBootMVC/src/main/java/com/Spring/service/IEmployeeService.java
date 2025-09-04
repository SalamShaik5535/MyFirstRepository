package com.Spring.service;

import java.util.List;

import com.Spring.entity.Employee;

public interface IEmployeeService {

	public Employee saveEmployee(Employee employee);
	public List<Employee> findAllEmployee();
	public Employee getEmployeeById(int id);
	public Employee updateEmployee(int id,Employee employee);
	public void deleteEmployee(int id);
}
