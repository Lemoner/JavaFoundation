package com.lmr.thread3;

public class MyThread9 extends Thread{

	private String u;
	
	public MyThread9(String u) {
		this.u=u;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		if("a".equals(u)&&ValueObject.local.get()==null){
			System.out.println("++++++");
			ValueObject.local.set("thread is "+u);
		}
		System.out.println(ValueObject.local.get());
	}

}
