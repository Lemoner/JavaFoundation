package com.lmr.concurrent.cyclicbarrier;

public class MyThread3 extends Thread {

	private MyService3 service;

	public MyThread3(MyService3 service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.method();
	}

}
