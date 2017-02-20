package com.lmr.test;

//类型参数模版

public class TestType {

	public static void main(String[] args) {
		
		Person x=new Person();
		x.something=1;
		System.out.println(x.toString());
		x.something="str";
		System.out.println(x);
		
		Person<Integer> y=new Person<Integer>();
		y.something=1;
		Person<String> z=new Person<String>();
		z.something="str";
		
		System.out.println(y.something);
		System.out.println(z.something);
		
	}
	
}

class Person<T>{
	public Integer age;
	public String name;
	public T something;
}
