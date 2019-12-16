package com.lmr.concurrent.semaphore;

public class MyThread4 extends Thread{

	private MyService4 service;
	
	public MyThread4(MyService4 service){
		this.service=service;
	}

	@Override
	public void run() {
//		while(true){
		for(int i=0;i<10;i++){
			String value=service.get();
			System.out.println(Thread.currentThread().getName()+" is get "+value);
			service.put(value);
		}
	}

}
