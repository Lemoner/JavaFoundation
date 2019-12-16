package com.lmr.invoke;

public class TestStatic {

	static int x;
	
	static{
		x=10;
		System.out.println("static=...");
	}
	
	public TestStatic() {
		x++;
		System.out.println("TestStatic "+x);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
//		TestStatic static1=new TestStatic();
//		TestStatic static2=new TestStatic();
		
		Class class1=Class.forName("com.lmr.invoke.TestStatic");
		Object obj1=class1.newInstance();
		
		Class class2=Class.forName("com.lmr.invoke.TestStatic",true,Student.class.getClassLoader());
		Object obj2=class2.newInstance();
		
	}
	
}
