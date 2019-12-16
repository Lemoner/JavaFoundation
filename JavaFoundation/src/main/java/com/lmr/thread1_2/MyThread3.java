package com.lmr.thread1_2;

public class MyThread3 extends Thread{

	private String u;
	private MyObject2 myObject;
	private MyService2 myService;
	
	public MyThread3(MyService2 myService, MyObject2 myObject, String u){
		this.myService=myService;
		this.myObject=myObject;
		this.u=u;
	}

	@Override
	public void run() {
		super.run();
		if("a".equals(u)){
			myService.method(myObject,u);
		}
		else{
			myObject.method2(u);
		}
		
	}
	
	
	
}
