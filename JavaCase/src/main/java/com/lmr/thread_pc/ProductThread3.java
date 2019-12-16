package com.lmr.thread_pc;

public class ProductThread3 extends Thread{

	private Service service;
	
	public ProductThread3(Service service) {
		this.service=service;
	}

	@Override
	public void run() {
//		while(true){
//			service.set();
//		}
		for(int i=0;i<50;i++){
			service.set();
		}
	}
	
}
