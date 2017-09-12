package com.lmr.thread3;

public class TestThread6 {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread9 thread1=new MyThread9("a");
		thread1.start();
		
		Thread.sleep(1000);
		
		MyThread9 thread2=new MyThread9("b");
		thread2.start();
		
		Thread.sleep(1000);
		
//		thread1=new MyThread9("a");
//		thread1.start();
		
		thread1.run();
		
	}
	
}
