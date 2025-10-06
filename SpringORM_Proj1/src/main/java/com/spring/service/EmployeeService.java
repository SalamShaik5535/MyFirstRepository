package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmployeeDAO;
import com.spring.dto.EmployeeDTO;
import com.spring.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;
	
	public List<EmployeeDTO> selectAllEmployee(){
		
		List<Employee> emp = employeeDao.selectAllEmployee();
		List<EmployeeDTO> list = new ArrayList<>();
		for(Employee e : emp) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setId(e.getId());
			dto.setName(e.getName());
			dto.setRole(e.getRole());
			dto.setSalary(e.getSalary());
			dto.setCity(e.getCity());
			list.add(dto);
		}
		return list;
	}

	public void createEmployee(Employee emp) {
	 employeeDao.createEmployee(emp);
	}
	
	public Employee findEmployee(int id) {
		return employeeDao.findEmployee(id);
	}
}
