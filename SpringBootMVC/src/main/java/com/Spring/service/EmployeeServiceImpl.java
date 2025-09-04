package com.Spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.entity.Employee;
import com.Spring.repo.IEmployeeRepo;
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo empRepo;
	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public List<Employee> findAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return empRepo.findById(id).orElse(null);
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee emp = empRepo.findById(id).orElse(null);
		if(emp!=null) {
			emp.setName(employee.getName());
			emp.setRole(employee.getRole());
			emp.setAddrs(employee.getAddrs());
			return empRepo.save(emp);
		}
		return emp;
	}

	@Override
	public void deleteEmployee(int id) {
		empRepo.deleteById(id);
	}

}
