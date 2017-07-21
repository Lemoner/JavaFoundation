package com.lmr.test;

public class TestObjectPass {
	
	public TestObjectPass() {

		Student stu1=new Student(1, "A", 12);
		Student stu2=new Student(2, "B", 16);
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
		
		System.out.println("--------------------");
		
		changeStudent(stu1,stu2);
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
		
	}

	public static void main(String[] args) {
		
		TestObjectPass top=new TestObjectPass();
		
	}

	private void changeStudent(Student stu1,Student stu2) {
		// TODO Auto-generated method stub
		
		stu1.setAge(19);
		stu2=stu1;
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
		
		System.out.println("--------------------");
		
	}
	
}
