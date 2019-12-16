package com.lmr.concurrent.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyService1 {

	private CyclicBarrier cyclicBarrier;
	private Thread startThread;
	
	public MyService1(){
		initStartThread();
		cyclicBarrier=new CyclicBarrier(3, startThread);
	}

	private void initStartThread() {
		
		startThread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("This round is start "+cyclicBarrier.getNumberWaiting());
				
			}
		});
		
	}
	
	public void method(){
		
		try {
			System.out.println(Thread.currentThread().getName()+" is wait "+cyclicBarrier.getNumberWaiting());
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName()+" is run");
			Thread.sleep(new Random().nextInt(10)*100);
			System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
