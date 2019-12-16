package com.lmr.test;

public class TestParm {

	public static void main(String[] args) {
		
//		String s="123";
		String s=new String("112");
		Change(s);
		System.out.println(s);
		
		Student stu=new Student();
		System.out.println(stu.toString());
		ChangeStudent(stu);
		System.out.println(stu.toString());
		
	}

	private static void ChangeStudent(Student stu) {
		// TODO Auto-generated method stub
		stu.setAge(12);
	}

	private static void Change(String s) {
		// TODO Auto-generated method stub
		s="1";
	}
	
}
