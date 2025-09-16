package com.Spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.dao.EmployeeDAO;
import com.Spring.entity.Employee;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
	}
	public Employee findEmployee(int id){
		return employeeDao.findEmployee(id);
	}
	public List<Employee> getAllEmployee(){
		return employeeDao.employeeAll();
	}
	public String updateEmployee(int id,String role) {
		employeeDao.updateEmployee(id, role);
		return "Employee With "+id+" AND Role "+role+" Updated";
	}
	public String deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
		return "Employee With ID "+id+" Deleted";
				
	}

}
