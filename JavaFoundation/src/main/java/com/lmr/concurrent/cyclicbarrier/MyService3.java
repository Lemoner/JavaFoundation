package com.lmr.concurrent.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyService3 {

	private CyclicBarrier cyclicBarrier;
	private Random random=new Random();
	private String win=null;
	
	public MyService3(){
		
//		cyclicBarrier=new CyclicBarrier(5);
		
		cyclicBarrier=new CyclicBarrier(5, new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				System.out.println("All is end winner is "+win);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("All is restart");
				win=null;
				
			}
		}));
		
	}
	
	public void method(){
		
		while(true){
			try {
				Thread.sleep((random.nextInt(10)+1)*100 );
				System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
				if(win==null){
					win=Thread.currentThread().getName();
				}
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
