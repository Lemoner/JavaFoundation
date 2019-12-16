package com.lmr.collection;

public class Person implements Comparable<Person>{

	private int id;
	private String name;
	private int age;
	
	public Person(int id,String name,int age) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return Integer.compare(age, o.age);//以年龄作为比较参数
	}
	
	
}
