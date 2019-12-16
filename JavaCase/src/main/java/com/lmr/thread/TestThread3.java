package com.lmr.thread;

public class TestThread3 extends Thread{

	public static void main(String[] args) {
		
		TestThread3 test=new TestThread3();
		test.start();
		
	}
	
	public void run(){
		System.out.println("789");
	}
	
//	public void start(){
//		System.out.println("123456");
//	}
	
}
