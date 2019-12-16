package com.lmr.thread1_2;

public class TestThread7 {

	public static void main(String[] args) {
		
		MyService3 service1=new MyService3();
		MyService3 service2=new MyService3();
		MyService3 service3=new MyService3();
		
		MyThread4 thread1=new MyThread4(service1, "a");
		thread1.start();
		
		MyThread4 thread2=new MyThread4(service2, "b");
		thread2.start();
		
		MyThread4 thread3=new MyThread4(service3, "c");
		thread3.start();
		
	}
	
}
