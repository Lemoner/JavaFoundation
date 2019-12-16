package com.lmr.thread1_2;

public class TestThread1 {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i=0;i<10;i++){
					System.out.println("Thread: "+i);
				}
				
			}
		});
		
		t.start();
		
		for(int i=90;i<100;i++){
			System.out.println(i);
			Thread.sleep(0);
		}
		
	}
	
}
