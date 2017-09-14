package com.lmr.thread4;

public class MyThread3 extends Thread{

	private String s;
	private MyService3 service;
	
	public MyThread3(MyService3 service, String s){
		this.service=service;
		this.s=s;
	}

	@Override
	public void run() {
		service.await(s);
	}

}
