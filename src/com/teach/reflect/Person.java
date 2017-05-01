package com.etc.demo.reflect;

import java.io.Serializable;

public class Person extends Animal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String sex;
	private int age;
	
	public int aa;
	
	public Person(){
		
	}
	
	public Person(String name, String sex){
		this.name = name;
		this.sex = sex;
	}
	
	public void study(String a, String b){
		System.out.println("ѧϰ");
	}
	
	public void show(){
		System.out.println(name);
	}
	
	private String shows(){
		return "";
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
	
	
}
