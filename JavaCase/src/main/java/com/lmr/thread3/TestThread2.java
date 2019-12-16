package com.lmr.thread3;

public class TestThread2 {

	public static void main(String[] args) throws InterruptedException {
		
		Object lock=new Object();
		
		for(int i=0;i<5;i++){
			MyThread3 thread=new MyThread3(lock, new String(Character.toChars('A'+i)));
			thread.start();
		}
		
		Thread.sleep(1000);
		
		MyThread3 notifythread=new MyThread3(lock, "*");
		notifythread.start();
		
	}
	
}
