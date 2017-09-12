package com.lmr.thread3;

public class TestThread3 {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread5 thread5=new MyThread5();
		MyThread4 thread4=new MyThread4(thread5);
		
		thread4.start();
		thread4.join();
//		thread5.start();
		
		
//		Thread.sleep(2000);
//		thread5.join();
//		thread5.join(1000);
//		thread4.join(1000);
		
		System.out.println("main end "+System.currentTimeMillis());
		
	}
	
}
