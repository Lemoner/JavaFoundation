package com.lmr.thread3;

public class MyThread2 extends Thread{

	private Object lock;
	
	public MyThread2(Object lock) {
		this.lock=lock;
	}
	
	@Override
	public void run() {
		System.out.println("MyThread2 is start ...");
		synchronized (lock) {
			for(int i=1;i<=10;i++){
				System.out.println("MyThread2 for is "+i);
				if(i==5){
					System.out.println("MyThread2 start notify "+System.currentTimeMillis());
					lock.notify();
					System.out.println("MyThread2 end notify "+System.currentTimeMillis());
				}
			}
			System.out.println("---------- MyThread2 synchronized is end ----------");
		}
		for(int i=1;i<=5;i++){
			System.out.println("MyThread2 for is "+i);
		}
		System.out.println("MyThread2 is end ...");
	}

}
