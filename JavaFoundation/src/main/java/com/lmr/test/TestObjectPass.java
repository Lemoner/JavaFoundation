package com.lmr.test;

import java.util.ArrayList;
import java.util.List;

public class TestObjectPass {
	
	private static Student sstu=null;
	
	public static void main(String[] args) {
		
//		TestStudentSwap();
//		TestRefOne();
//		TestRefTwo();
		TestObjectRefList();
		
	}
	
	public static void TestObjectRefList(){
		
		Student stu1=new Student(1, "A", 11);
		Student stu2=new Student(2, "S", 22);
		Student stu3=new Student(3, "D", 33);
		
		List<Student> stulist=new ArrayList<Student>();
		stulist.add(stu1);
		stulist.add(stu2);
		stulist.add(stu3);
		
		System.out.println(stulist.toString());
		
		ChangeStudentList(stulist);
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
		System.out.println(stu3.toString());
		System.out.println(stulist.toString());
		
	}
	
	private static void ChangeStudentList(List<Student> stulist) {
		
		for (Student student : stulist) {
			student.setAge(99);
		}
		
	}
	
	public static void TestRefOne(){
		
		int a=10;
		
		System.out.println("start: "+a);
		ChangeData(a);
		System.out.println("end: "+a);
		
	}

	private static void ChangeData(int a) {
		System.out.println("ChangeData start: "+a);
		a=99;
		System.out.println("ChangeData end: "+a);
	}

	public static void TestRefTwo(){
		
		Student stu1=new Student(1, "A", 11);
		
		SetStaticStudent(stu1);
		
		System.out.println(stu1.toString());
		ChangeStudent(stu1);
		System.out.println(stu1.toString());
		
		SetStaticStudent(stu1);
	}
	
	private static void SetStaticStudent(Student stu) {
		
		if(sstu==null){
			sstu=stu;
			System.out.println("已赋值给静态变量: "+sstu.toString());
		}
		else{
			System.out.println("使用原有的静态变量: "+sstu.toString());
		}
		
	}

	private static void ChangeStudent(Student stu) {
		stu.setAge(22);
	}

	public static void TestStudentSwap(){
		
		Student stu1=new Student(1, "A", 12);
		Student stu2=new Student(2, "B", 16);
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
		
		System.out.println("--------------------");
		
		changeStudent(stu1,stu2);
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
		
	}

	private static void changeStudent(Student stu1,Student stu2) {
		
		stu1.setAge(19);
		stu2=stu1;
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
		
		System.out.println("--------------------");
		
	}
	
}
