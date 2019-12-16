package com.lmr.concurrent.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class MyService2 {

	private ReentrantLock lock=new ReentrantLock();
	private CountDownLatch countDownLatch=new CountDownLatch(3);
	private CyclicBarrier cyclicBarrier;
	private Thread startThread;
	private Thread checkThread;
	
	public MyService2(){
		initStartThread();
		cyclicBarrier=new CyclicBarrier(3, startThread);
//		cyclicBarrier=new CyclicBarrier(3);
	}

	private void initStartThread() {
		
		startThread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				checkMethod();
				
			}
		});
		
	}
	
	public void checkMethod(){
		
		checkThread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					lock.lock();
					
					System.out.println("This round is start "+cyclicBarrier.getNumberWaiting());
					
					countDownLatch.await();
					
					System.out.println("This round is end ");
					
					countDownLatch=new CountDownLatch(3);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
				
			}
		});
		
	}
	
	public void method(){
		
		try {
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName()+" is wait "+cyclicBarrier.getNumberWaiting());
//			cyclicBarrier.await();
//			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+" is run "+System.currentTimeMillis());
//			Thread.sleep(1000);
//			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName()+" is end "+System.currentTimeMillis());
//			cyclicBarrier.await();
			countDownLatch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
