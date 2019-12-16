package com.lmr.concurrent.semaphore;

public class MyThreadP extends Thread {

	private MyServicePC servicePC = new MyServicePC();

	public MyThreadP(MyServicePC servicePC) {
		this.servicePC = servicePC;
	}

	@Override
	public void run() {
		servicePC.set();
	}

}
