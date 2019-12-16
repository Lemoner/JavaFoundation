package com.lmr.thread_pc;

public class ConsumerThread3 extends Thread{

	private Service service;
	
	public ConsumerThread3(Service service) {
		this.service=service;
	}
	
	@Override
	public void run() {
//		while(true){
//			service.get();
//		}
		for(int i=0;i<50;i++){
			service.get();
		}
	}
	
}
