package com.lmr.interfaces;

public class Test {

	public static void main(String[] args) {
		
		Person s=new Student("Jack");
		s.eat();
		s.sleep();
		
		Person t=new Teacher();
		t.eat();
		t.sleep();
		
//		Student st=new Student();
//		st.eat();
		
		School school=new School();
		school.eat(s);
		school.sleep(s);
		
		
		
	}
	
}
