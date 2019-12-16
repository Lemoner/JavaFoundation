package com.lmr.thread_pc;

public class TestPCThread1 {

	public static void main(String[] args) {
		
		Object lock=new Object();
		
		Product1 product=new Product1(lock);
		Consumer1 consumer=new Consumer1(lock);
		
		for(int i=0;i<10;i++){
			ProductThread1 productThread=new ProductThread1(product);
			productThread.start();
			ConsumerThread1 consumerThread=new ConsumerThread1(consumer);
			consumerThread.start();
		}
		
	}
	
}
