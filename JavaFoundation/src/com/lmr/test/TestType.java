package com.lmr.test;

//类型参数模版

public class TestType {

	public static void main(String[] args) {
		
		TPerson x=new TPerson();
		x.something=1;
		System.out.println(x.toString());
		x.something="str";
		System.out.println(x);
		
		TPerson<Integer> y=new TPerson<Integer>();
		y.something=1;
		TPerson<String> z=new TPerson<String>();
		z.something="str";
		
		System.out.println(y.something);
		System.out.println(z.something);
		
	}
	
}

class TPerson<T>{
	public Integer age;
	public String name;
	public T something;
}
