package com.lmr.thread1_2;

public class TestThread6 {

	public static void main(String[] args) {
		
		MyObject2 myObject=new MyObject2();
		MyService2 myService=new MyService2();
		
		MyThread3 thread1=new MyThread3(myService, myObject, "a");
		thread1.start();
		
		MyThread3 thread2=new MyThread3(myService, myObject, "b");
		thread2.start();
		
	}
	
}
