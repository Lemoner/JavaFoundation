package com.lmr.thread1_2;

public class MyThread8 extends Thread {

	@Override
	public void run() {
		
		System.out.println("MyThread is run");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("MyThread is end");
		
	}

}
