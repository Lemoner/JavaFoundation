package com.lmr.concurrent_art;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TestVolatile {

	public static void main(String[] args) {
		
		TestVolatile test=new TestVolatile();
		
		test.TestOne();
		
	}

	public void TestOne() {
		
		AtomicInteger x=new AtomicInteger(0);
		
		for(int i=0;i<5;i++){
			Thread thread=new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					for(int k=0;k<3;k++){
						x.getAndIncrement();
					}
					
				}
			});
			thread.start();
		}
		
		while(Thread.activeCount()>1){  
			Thread.yield();
		}
		
		System.out.println(x);
		
	}
	
}
