package com.lmr.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MyService1 {

	private CountDownLatch countDownLatch=new CountDownLatch(5);
	
	public void end(){
		try {
			System.out.println("Is wait all end . . . "+System.currentTimeMillis());
			countDownLatch.await();
			System.out.println("All is end "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void method(){
		System.out.println(Thread.currentThread().getName()+" is run "+System.currentTimeMillis());
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
		countDownLatch.countDown();
	}
	
}
