package com.lmr.concurrent.countdownlatch;

public class MyThread3 extends Thread {

	private MyService3 service = new MyService3();

	public MyThread3(MyService3 service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.method();
	}

}
