package com.lmr.thread1_2;

public class MyThread5 extends Thread{

	private String u;
	private MyService4 myService;
	
	public MyThread5(MyService4 myService, String u){
		this.myService=myService;
		this.u=u;
	}

	@Override
	public void run() {
		super.run();
		myService.method(u);
	}
	
}
