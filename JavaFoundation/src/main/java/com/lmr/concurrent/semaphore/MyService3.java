package com.lmr.concurrent.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MyService3 {

	private Semaphore semaphore=new Semaphore(1);
	
	public void method(){
		
		try {
			if(semaphore.tryAcquire()){
//			if(semaphore.tryAcquire(1500, TimeUnit.SECONDS)){
				System.out.println(Thread.currentThread().getName()+" tryAcquire ok "+System.currentTimeMillis());
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
				semaphore.release();
			}
			else{
				System.out.println(Thread.currentThread().getName()+" tryAcquire is not "+System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
