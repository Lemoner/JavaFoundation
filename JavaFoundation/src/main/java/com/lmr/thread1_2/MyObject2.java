package com.lmr.thread1_2;

public class MyObject2 {
	
	public void method1(String u){
		try {
			synchronized (this) {
				System.out.println(u+" - synchronized code - begin - "+System.currentTimeMillis());
				Thread.sleep(1000);
				System.out.println(u+" - synchronized code - end - "+System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	synchronized public void method2(String u){
		try {
			System.out.println(u+" - synchronized method - begin - "+System.currentTimeMillis());
			Thread.sleep(500);
			System.out.println(u+" - synchronized method - end - "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
}
