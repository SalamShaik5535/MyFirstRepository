package com.Java.JavaPrograming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Data{
	int id;
	String course;
	double fees;
	public Data(int id,String course,double fees) {
		this.id=id;
		this.course=course;
		this.fees=fees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
}
public class CollectionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Map<String,Object>> list = new ArrayList<>();
		
		Map<String,Object> map1 = new HashMap<>();
		map1.put("Salam", new Data(101,"Java",1200));
		map1.put("Prabhas", new Data(102,"Oracle",300));
		map1.put("Ntr", new Data(103,"Pythod",1500));
		map1.put("Ram", new Data(104,"Js",900));
		map1.put("Ravi", new Data(105,"css",1300));
		map1.put("Nani", new Data(106,"Html",700));
		
		Map<String,Object> map2 = new HashMap<>();
		map2.put("Ranbir", new Data(107,"Java",1100));
		map2.put("Akshay", new Data(108,"Oracle",1300));
		map2.put("Salman", new Data(109,"Pythod",100));
		map2.put("Sharuk", new Data(110,"Js",1900));
		map2.put("Tigershroff", new Data(111,"css",300));
		map2.put("Hrutik", new Data(112,"Html",1700));
		
		Map<String,Object> map3 = new HashMap<>();
		map3.put("Viram", new Data(113,"Java",1200));
		map3.put("Surya", new Data(114,"Oracle",300));
		map3.put("Vijay", new Data(115,"Pythod",1500));
		map3.put("Rajini", new Data(116,"Js",900));
		map3.put("dulkar", new Data(117,"css",1300));
		map3.put("sethupati", new Data(118,"Html",700));
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		for(Map<String,Object> map: list){
			for(Map.Entry<String, Object> entry : map.entrySet()) {
			String name = 	entry.getKey();
			Data data = (Data)entry.getValue();
			System.out.println(name);
			System.out.println(data.getId()+" "+data.getCourse()+" "+data.getFees());
			}
		}
	}

}
