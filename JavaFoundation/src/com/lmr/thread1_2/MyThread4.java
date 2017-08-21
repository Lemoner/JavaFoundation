package com.lmr.thread1_2;

public class MyThread4 extends Thread{

	private String u;
	private MyService3 myService;
	
	public MyThread4(MyService3 myService, String u){
		this.myService=myService;
		this.u=u;
	}

	@Override
	public void run() {
		super.run();
		if("a".equals(u)){
			myService.service1(u);
		}
		else if("b".equals(u)){
			myService.service2(u);
		}
		else{
			myService.service3(u);
		}
	}
	
	
	
}
