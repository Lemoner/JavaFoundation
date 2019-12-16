package com.lmr.thread1_2;

public class MyService4 {
	
	private String lock="123";
	
	public void method(String u){
		try {
			synchronized (lock) {
				System.out.println(u+" - method - begin - "+System.currentTimeMillis());
				lock="456";
				Thread.sleep(1000);
				System.out.println(u+" - method - end - "+System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
