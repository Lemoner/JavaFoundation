package com.lmr.concurrent.phaser;

public class MyThread3 extends Thread {

	private String s;
	private MyService3 service;
	
	public MyThread3(MyService3 service, String s) {
		this.service=service;
		this.s=s;
	}
	
	@Override
	public void run() {
		if("B".equals(s)){
			service.method2();
//			service.method1();
		}
		else{
			service.method1();
		}
	}

}
