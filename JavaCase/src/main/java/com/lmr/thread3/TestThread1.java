package com.lmr.thread3;

public class TestThread1 {

	public static void main(String[] args) throws InterruptedException {
		
		Object lock=new Object();
		
		MyThread1 thread1=new MyThread1(lock);
		thread1.start();
		Thread.sleep(300);
		MyThread2 thread2=new MyThread2(lock);
		thread2.start();
		
	}
	
}
