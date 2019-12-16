package com.lmr.thread1_2;

public class MyService2 {
	
	public void method(MyObject2 myObject,String u){
		synchronized(myObject){
			try {
				System.out.println(u+" - MyService2 synchronized - begin - "+System.currentTimeMillis());
				Thread.sleep(500);
				System.out.println(u+" - MyService2 synchronized - end - "+System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
