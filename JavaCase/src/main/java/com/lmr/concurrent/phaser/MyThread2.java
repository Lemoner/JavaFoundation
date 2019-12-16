package com.lmr.concurrent.phaser;

public class MyThread2 extends Thread {

	private String s;
	private MyService2 service;
	
	public MyThread2(MyService2 service, String s) {
		this.service=service;
		this.s=s;
	}
	
	@Override
	public void run() {
		if("B".equals(s)){
			service.method2();
		}
		else{
			service.method1();
		}
	}

}
