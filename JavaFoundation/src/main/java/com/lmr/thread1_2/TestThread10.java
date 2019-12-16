package com.lmr.thread1_2;

public class TestThread10 {

	public static void main(String[] args) throws InterruptedException {
		
		MyService5 service=new MyService5();
		
		MyThread7 thread1=new MyThread7("a", service);
		thread1.start();
		
		Thread.sleep(500);
		
		MyThread7 thread2=new MyThread7("b", service);
		thread2.start();
		
		System.out.println("send stop message ...");
		
	}
	
}
