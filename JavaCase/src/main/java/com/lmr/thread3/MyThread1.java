package com.lmr.thread3;

public class MyThread1 extends Thread{

	private Object lock;
	
	public MyThread1(Object lock) {
		this.lock=lock;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("MyThread1 is start ...");
			synchronized (lock) {
				System.out.println("MyThread1 start wait "+System.currentTimeMillis());
				lock.wait();
				System.out.println("MyThread1 end wait "+System.currentTimeMillis());
				for(int i=1;i<=5;i++){
					System.out.println("MyThread1 for is "+i);
				}
			}
			System.out.println("MyThread1 is end ...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
