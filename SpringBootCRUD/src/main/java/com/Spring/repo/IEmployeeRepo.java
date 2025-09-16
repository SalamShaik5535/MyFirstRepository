package com.Spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.entity.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

}
