package com.lmr.test;

import java.io.Serializable;

public class Person implements Serializable{

	private String name;
	private int age;
	private transient int id;
	private static int count=0;
	
//	public Person(){
//		id=++count;
//	}
	
	public Person(String name,int age) {
		// TODO Auto-generated constructor stub
//		this();
		id=++count;
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
