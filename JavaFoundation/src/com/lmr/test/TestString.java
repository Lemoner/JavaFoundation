package com.lmr.test;

public class TestString {

	public static void main(String[] args) {
		
//		TestOne();
		TestTwo();
		
	}

	private static void TestTwo() {
		
		System.out.println('a'+1);
		System.out.println(Character.toString((char)('a'+1)));
		System.out.println(new String("a"+1));
		
	}

	private static void TestOne() {
		
		String a1="aa";
		String b1="aa";
		
		System.out.println(a1==b1);
		
		String a2=new String("aa");
		String b2=new String("aa");
		
		System.out.println(a2==b2);
		
	}
	
}
