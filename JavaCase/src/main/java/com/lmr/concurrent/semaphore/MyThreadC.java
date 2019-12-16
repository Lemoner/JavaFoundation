package com.lmr.concurrent.semaphore;

public class MyThreadC extends Thread {

	private MyServicePC servicePC = new MyServicePC();

	public MyThreadC(MyServicePC servicePC) {
		this.servicePC = servicePC;
	}

	@Override
	public void run() {
		servicePC.get();
	}

}
