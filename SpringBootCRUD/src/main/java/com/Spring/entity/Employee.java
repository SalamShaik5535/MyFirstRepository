package com.Spring.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee_Info")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String role;
	private double salary;
	private String city;
	
	public Employee(){
		System.out.println("Employee Class Loaded...");
	}
	public Employee(int id,String name,String role,double salary,String city) {
		this.id=id;
		this.name=name;
		this.role = role;
		this.salary=salary;
		this.city=city;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setRole(String role) {
		this.role=role;
	}
	public String getRole() {
		return role;
	}
	public void setSalary(double salary) {
		this.salary=salary;
	}
	public double getSalary() {
		return salary;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public String getCity() {
		return city;
	}
	
}
