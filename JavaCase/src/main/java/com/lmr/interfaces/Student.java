package com.lmr.interfaces;

public class Student implements Person{

	private String name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("学生"+name+"去食堂吃饭");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("学生"+name+"回宿舍睡觉");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
