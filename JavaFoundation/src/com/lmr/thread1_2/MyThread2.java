package com.lmr.thread1_2;

public class MyThread2 extends Thread{

	private String u;
	private MyObject2 myObject;
	
	public MyThread2(MyObject2 myObject, String u){
		this.myObject=myObject;
		this.u=u;
	}

	@Override
	public void run() {
		super.run();
		if("a".equals(u)){
			myObject.method1(u);
		}
		else{
			myObject.method2(u);
		}
		
	}
	
	
	
}
