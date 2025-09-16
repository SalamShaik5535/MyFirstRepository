package com.Spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Spring.entity.Employee;
import com.Spring.repo.IEmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private IEmployeeRepo empRepo;
	
	 public EmployeeService(IEmployeeRepo repo) {
	        this.empRepo = repo;
	    }

	    public Employee save(Employee employee) {
	        return empRepo.save(employee);
	    }

	    public List<Employee> findAll() {
	        return empRepo.findAll();
	    }

	    public Employee findById(Integer id) {
	        return empRepo.findById(id).orElse(null);
	    }

	    public Employee update(Integer id, Employee employee) {
	        Employee existing = empRepo.findById(id).orElse(null);
	        if (existing != null) {
	            existing.setName(employee.getName());
	            existing.setCity(employee.getCity());
	            existing.setSalary(employee.getSalary());
	            return empRepo.save(existing);
	        }
	        return existing;
	    }

	    public void delete(Integer id) {
	        empRepo.deleteById(id);
	    }
	
	    public Page<Employee> findAllEmp(Pageable pageable){
			return empRepo.findAll(pageable);
	    	
	    }
}
