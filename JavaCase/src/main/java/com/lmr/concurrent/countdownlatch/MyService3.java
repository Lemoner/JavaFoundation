package com.lmr.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MyService3 {

	private CountDownLatch startCountDownLatch=new CountDownLatch(1);
	private CountDownLatch endCountDownLatch=new CountDownLatch(5);
	
	public void init(){
		
		try {
			System.out.println("All is start");
			startCountDownLatch.countDown();
			System.out.println("wait...");
			endCountDownLatch.await();
			System.out.println("All is end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void method(){
		
		try {
			System.out.println(Thread.currentThread().getName()+" is wait");
			startCountDownLatch.await();
			System.out.println(Thread.currentThread().getName()+" is run "+System.currentTimeMillis());
			endCountDownLatch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
