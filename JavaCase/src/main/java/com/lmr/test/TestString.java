package com.lmr.test;

public class TestString {

//	public static void main(String[] args) {
//		
////		TestOne();
////		TestTwo();
////		TestThree();
//		TestFour();
//		
//	}
	
	public String name="abc"; 
    public static void main(String[] args){ 
    	TestString test=new TestString(); 
    	TestString testB=new TestString(); 
        System.out.println(test.equals(testB)+","+test.name.equals(testB.name)); 
        System.out.println(test.name.hashCode());
        System.out.println(testB.name.hashCode());
    } 
	
	private static void TestThree(){
		
		String s="123452729";
		System.out.println(s.replaceFirst('2'+"", 'x'+""));
		System.out.println(s);
		
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
	
	private static void TestFour(){
		
		String s="10.1.16.89";
		System.out.println(s.split("\\.")[3]);
		
	}
	
}
