package com.lmr.thread;

public class MyThread1 extends Thread{

	private int count=10;
	
	private String name;
	
	public MyThread1(String name){
		this.name=name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(this.count>0){
			System.out.println(name+"  "+this.count--);
		}
		
	}
	
}
