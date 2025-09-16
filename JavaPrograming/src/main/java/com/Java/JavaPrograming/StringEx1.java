package com.Java.JavaPrograming;

import java.util.Arrays;

public class StringEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "Hello";
		String str2 = str1+" World!";
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		String wish = str1.concat(" Welcome!");
		System.out.println(wish+" "+wish.hashCode());
		
		String city1 = "Chennai";
		String city2 = "Chennai";
		System.out.println(city1==city2);
		System.out.println(city1.equals(city2));
		
		String name1 = new String("Salam");
		String name2 = new String("Salam");
		System.out.println(name1.equals(name2)); //content comparision
		System.out.println(name1==name2); //reference comparision
		
		String str3 = new String("Hello World!");
		String str4 = new String("Hello World!");
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		String str5 = str4+" Welcome.";
		System.out.println(str5.hashCode());
		
		StringBuffer sb = new StringBuffer("Lion");
		StringBuffer sb1 = new StringBuffer("King");
		System.out.println(sb.hashCode()+" "+sb1.hashCode());
		StringBuffer sb2 = sb.append(sb1);
		System.out.println(sb2);
		
		StringBuffer sb3 = new StringBuffer("He Wold! How");
		sb3.insert(2, "llo");
		sb3.insert(9, "r");
		System.out.println(sb3);
		
		sb3.delete(12, 16);
		System.out.println(sb3);
		
		System.out.println(sb3.length());
		String say = new String("Java").intern();
		System.out.println(say);
		
		//=========================================================
		
		char []ch = {'a','b','c','d','e','f'};
		String sc = new String(ch);
		System.out.println(sc);
		String sc2 = new String(ch,2,4);
		System.out.println(sc2);
		
		String msg = (new StringBuffer("Hello ")).append("World ").append("Welcome").toString();
		System.out.println(msg);
		
		String bigMsg = String.join("",msg," To MyWorld!");
		System.out.println(bigMsg);
		
		String visit = String.format(bigMsg, "-");
		System.out.println(visit);
		
		String msgTo = new String("I am Java");
		String [] s = msgTo.split("\\.");
		String actual = Arrays.toString(s);
		System.out.println(actual);
		
		//=====================================
		
		StringBuffer sbr = new StringBuffer("Make");
		System.out.println(sbr.reverse());
		
		StringBuffer sbn = new StringBuffer("Hello");
		StringBuffer sbff = sbn.reverse();
		System.out.println(sbff==sbn); 
		 
	}

}
