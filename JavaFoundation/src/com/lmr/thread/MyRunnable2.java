package com.lmr.thread;

public class MyRunnable2 implements Runnable{
	int count=10;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+"   "+count--);
			}
		}
	}
}
