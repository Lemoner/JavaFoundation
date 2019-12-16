package com.lmr.concurrent.executorservice.scheduledexecutorservice;

public class MyRunnable implements Runnable{

	private String s;
	private int t=0;
	
	private int count=0;
	
	public MyRunnable(String s) {
		this.s=s;
	}
	
	public MyRunnable(String s, int t){
		this.s=s;
		this.t=t;
	}
	
	@Override
	public void run() {
		
		try {
			System.out.println(s+" is run "+System.currentTimeMillis()+" - "+(++count));
			Thread.sleep(t);
			System.out.println(s+" is end "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
