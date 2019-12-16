package com.lmr.concurrent.cyclicbarrier;

public class MyThread1 extends Thread {

	private MyService1 service;

	public MyThread1(MyService1 service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.method();
	}

}
