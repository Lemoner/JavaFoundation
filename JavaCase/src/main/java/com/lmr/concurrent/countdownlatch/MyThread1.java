package com.lmr.concurrent.countdownlatch;

public class MyThread1 extends Thread {

	private MyService1 service = new MyService1();

	public MyThread1(MyService1 service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.method();
	}

}
