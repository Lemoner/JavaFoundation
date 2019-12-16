package com.lmr.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class MyService1 {

	private Semaphore semaphore=new Semaphore(1);
	
	public void method(){
		
		try {
//			System.out.println(Thread.currentThread().getName()+" before acquire "+System.currentTimeMillis()+" permits is "+semaphore.availablePermits());
			semaphore.acquire();
//			System.out.println(Thread.currentThread().getName()+" is acquire "+System.currentTimeMillis()+" permits is "+semaphore.availablePermits());
			System.out.println(Thread.currentThread().getName()+" is acquire "+System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
			semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
