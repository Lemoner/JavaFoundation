package com.lmr.thread4;

public class MyThread4 extends Thread{

	private MyService4 service;
	
	public MyThread4(MyService4 service){
		this.service=service;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is run");
		service.method();
	}

}
