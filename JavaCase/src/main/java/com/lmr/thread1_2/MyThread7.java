package com.lmr.thread1_2;

public class MyThread7 extends Thread{

	private String u;
	private MyService5 service;
	
	public MyThread7(String u, MyService5 service) {
		this.u=u;
		this.service=service;
	}
	
	@Override
	public void run() {
		if("a".equals(u)){
			service.runMethod();
		}
		else{
			service.stopMethod();
		}
	}
	
}
