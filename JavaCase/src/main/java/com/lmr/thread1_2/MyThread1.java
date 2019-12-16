package com.lmr.thread1_2;

public class MyThread1 extends Thread{

	private String u;
	private MyObject myObject;
	
	public MyThread1(MyObject myObject, String u){
		this.myObject=myObject;
		this.u=u;
	}

	@Override
	public void run() {
		super.run();
//		myObject.add(u);
		
		if("a".equals(u)){
			myObject.adda(u);
//			myObject.sum(u);
		}
		else{
			myObject.sum(u);
			myObject.addb(u);
		}
		
	}
	
	
	
}
