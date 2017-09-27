package com.lmr.concurrent.phaser;

public class MyThread1 extends Thread {

	private String s;
	private MyService1 service;
	
	public MyThread1(MyService1 service, String s) {
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
