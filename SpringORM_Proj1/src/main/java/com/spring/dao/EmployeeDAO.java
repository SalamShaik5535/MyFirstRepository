package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Employee;

@Repository
public class EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Employee> selectAllEmployee(){
		Session session = sessionFactory.openSession();
		String query = "FROM Employee";
		Query q = session.createQuery(query);
		return q.list();
	}
	
	public void createEmployee(Employee emp) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Employee findEmployee(int id) {
		Session session = sessionFactory.openSession();
		String query = "FROM Employee WHERE id=:id";
		Query q = session.createQuery(query);
		q.setParameter("id", id);
		Employee emp = (Employee) q.uniqueResult();
		return emp;
		
	}
	
}
