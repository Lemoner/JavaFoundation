package com.lmr.thread1_2;

public class TestThread4 {

	public static void main(String[] args) {
		
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				MyService service=new MyService();
				service.service1();
				
			}
		});
		t.start();
		
	}
	
}
