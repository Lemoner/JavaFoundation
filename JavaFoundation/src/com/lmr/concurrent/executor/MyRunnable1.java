package com.lmr.concurrent.executor;

public class MyRunnable1 implements Runnable{

	private String s;
	
	public MyRunnable1(String s) {
		this.s=s;
	}
	
	@Override
	public void run() {
		
//		System.out.println(s+" start "+System.currentTimeMillis());
//		int i=1/0;
//		System.out.println(s+" end "+System.currentTimeMillis());
		
		try {
			System.out.println(s+" start "+System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println(s+" end "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
}
