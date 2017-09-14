package com.lmr.thread_pc;

public class TestPCThread3 {

	public static void main(String[] args) {
		
		Service service=new Service();
		ProductThread3 productThread=new ProductThread3(service);
		ConsumerThread3 consumerThread=new ConsumerThread3(service);
		
		productThread.start();
		consumerThread.start();
		
	}
	
}
