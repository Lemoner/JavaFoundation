package com.lmr.interfaces;

public class Teacher implements Person{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("老师回家吃饭");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("老师回家");
	}

}
