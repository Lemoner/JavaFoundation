package com.lmr.thread;

public class MyRunnable1 implements Runnable{

	private int count=10;
	
	private String name;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(this.count>0){
			System.out.println(Thread.currentThread().getName()+"  "+this.count--);
		}
		
	}
	
}
