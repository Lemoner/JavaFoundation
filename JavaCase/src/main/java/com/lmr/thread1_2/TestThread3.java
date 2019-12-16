package com.lmr.thread1_2;

public class TestThread3 {

	public static void main(String[] args) {
		
		MyObject myObject1=new MyObject();
//		MyObject myObject2=new MyObject();
		
		MyThread1 thread1=new MyThread1(myObject1, "a");
		thread1.start();
		
		MyThread1 thread2=new MyThread1(myObject1, "b");
		thread2.start();
		
	}
	
}
