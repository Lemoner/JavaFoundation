package com.lmr.concurrent.countdownlatch;

public class MyThread2 extends Thread {

	private MyService2 service = new MyService2();

	public MyThread2(MyService2 service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.method();
	}

}
