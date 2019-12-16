package com.lmr.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MyService2 {

	volatile private int sum=0;
	private CountDownLatch countDownLatch=new CountDownLatch(4);
	private Semaphore semaphore=new Semaphore(4,true);
	
	public void end(){
		try {
			System.out.println("Is wait all end . . . "+System.currentTimeMillis()+" sum is "+sum);
			while(true){
				countDownLatch.await();
				System.out.println("All is end "+System.currentTimeMillis()+" sum is "+sum);
				sum=0;
				countDownLatch=new CountDownLatch(4);
				semaphore.release(4);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void method(){
//		try {
//			while(semaphore.tryAcquire(100, TimeUnit.MILLISECONDS)){
			while(semaphore.tryAcquire()){
				sum=sum+1;
				System.out.println(Thread.currentThread().getName()+" is run "+System.currentTimeMillis()+" sum is "+sum);
				countDownLatch.countDown();
				break;
			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
