package com.lmr.thread_pc;

public class TestPCThread2 {

	public static void main(String[] args) {
		
		Object plock=new Object();
		Object clock=new Object();
		
		Product2 product=new Product2(plock, clock);
		Consumer2 consumer=new Consumer2(plock, clock);
		
		ProductThread2 productThread=new ProductThread2(product);
		productThread.start();
		for(int i=0;i<10;i++){
			ConsumerThread2 consumerThread=new ConsumerThread2(consumer);
			consumerThread.start();
		}
		
	}
	
}
