package com.lmr.thread1_2;

public class TestThread5 {

	public static void main(String[] args) {
		
		MyObject2 myObject=new MyObject2();
		
		MyThread2 thread1=new MyThread2(myObject, "a");
		thread1.start();
		
		MyThread2 thread2=new MyThread2(myObject, "b");
		thread2.start();
		
	}
	
}
