package com.lmr.thread4;

public class MyThread2 extends Thread{

	private String s;
	private MyService2 service;
	
	public MyThread2(MyService2 service, String s){
		this.service=service;
		this.s=s;
	}

	@Override
	public void run() {
		service.await(s);
	}

}
