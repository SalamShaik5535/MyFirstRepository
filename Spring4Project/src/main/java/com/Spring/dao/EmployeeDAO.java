package com.Spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Spring.entity.Employee;

@Repository
public class EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public EmployeeDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void createEmployee(Employee employee) {
		getSession().save(employee);
	}
	
	public Employee findEmployee(int id) {
		String hql = "FROM Employee e WHERE e.id = :id";
		Query query =	getSession().createQuery(hql);
		query.setParameter("id", id);
		return (Employee) query.uniqueResult();
	}
	public List<Employee> employeeAll(){
		String hql = "FROM Employee e";
		Query q = getSession().createQuery(hql);
		return q.list();
	}
	
	public void updateEmployee(int id,String role) {
		String hql  = " UPDATE Employee e SET e.id = :id AND e.role = :role";
		getSession().createQuery(hql).setParameter("id", id).setParameter("role", role).executeUpdate();
	}
	
	public void deleteEmployee(int id) {
		String hql = "DELETE FROM Employee e WHERE e.id = :id";
		 getSession().createQuery(hql).setParameter("id", id).executeUpdate();
	}
}
