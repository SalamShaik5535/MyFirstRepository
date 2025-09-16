package com.Java.JavaPrograming;

import java.util.Arrays;
import java.util.Scanner;

interface Demo{
	public String display();
}
class Demo1 implements Demo	{

	@Override
	public String display() {

		return "Demo1 implements Demo class display()";
	}
	
}
public class SampleDemo {

	
	public static void main(String[] args) {
		Demo d = new Demo1();
		System.out.println(d.display());
		System.out.println(userBill());
	}
	public static String userBill() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Bill Id:");
		int	id= sc.nextInt();
		System.out.println("Enter Customer Name:");
		String name = sc.next();
		String[] items = {"Water","Chicken Biryani","Thumsup"};	
		double totalAmount = 20+120+15;
		return "Customer "+name+" Paying Bill With ID "+id+" For Items  "+Arrays.toString(items)+" in Total "+totalAmount+"$";
		}
	
}
