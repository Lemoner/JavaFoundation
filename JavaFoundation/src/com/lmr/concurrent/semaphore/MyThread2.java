package com.lmr.concurrent.semaphore;

public class MyThread2 extends Thread{

	private MyService2 service;
	
	public MyThread2(MyService2 service){
		this.service=service;
	}

	@Override
	public void run() {
		service.method();
	}

}
