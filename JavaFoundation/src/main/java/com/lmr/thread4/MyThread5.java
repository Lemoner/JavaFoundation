package com.lmr.thread4;

public class MyThread5 extends Thread{

	private MyService5 service;
	private String s;
	
	public MyThread5(MyService5 service, String s){
		this.service=service;
		this.s=s;
	}

	@Override
	public void run() {
		if("Read".equals(s)){
			service.ReadMethod();
		}
		else if("Write".equals(s)){
			service.WriteMethod();
		}
	}

}
