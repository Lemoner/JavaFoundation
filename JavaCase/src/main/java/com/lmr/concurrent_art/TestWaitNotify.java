package com.lmr.concurrent_art;

public class TestWaitNotify {
	
	private static Object lock=new Object();
	private static int count=0;

	
	public static void main(String[] args) {
		
		TestWaitNotify test=new TestWaitNotify();
		
		test.TestOne();
		
	}

	private void TestOne() {
		
		Thread cThread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					synchronized (lock) {
						while(count<=0){
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.out.println("cThread "+count);
						count--;
					}
				}
			}
		});
		
		Thread pThread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					synchronized (lock) {
						System.out.println("pThread "+count);
						while(count<=0){
							count++;
						}
						lock.notify();
					}
				}
			}
		});
		
		cThread.start();
		pThread.start();
		
	}

	
}
