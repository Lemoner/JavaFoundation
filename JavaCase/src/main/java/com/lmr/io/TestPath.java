package com.lmr.io;

public class TestPath {

	public static void main(String[] args) {
		
		TestPath test=new TestPath();
		
		test.TestOne();
		
	}

	private void TestOne() {
		
		System.out.println(System.getProperty("user.dir"));
		
		System.out.println(getClass().getResource("/"));
		
	}
	
}
