package com.lmr.thread_pc;

public class TestPCThread4 {

	public static void main(String[] args) {
		
		Service service=new Service();
		
		for(int i=1;i<=3;i++){
			ProductThread3 productThread=new ProductThread3(service);
			productThread.setName("productThread "+i);
			productThread.start();
			ConsumerThread3 consumerThread=new ConsumerThread3(service);
			consumerThread.setName("consumerThread "+i);
			consumerThread.start();
		}
		
//		for(int i=1;i<=3;i++){
//			ConsumerThread3 consumerThread=new ConsumerThread3(service);
//			consumerThread.setName("consumerThread "+i);
//			consumerThread.start();
//		}
		
	}
	
}
