package com.lmr.thread_pc;

public class ConsumerThread1 extends Thread{

	private Consumer1 consumer;
	
	public ConsumerThread1(Consumer1 consumer) {
		this.consumer=consumer;
	}
	
	@Override
	public void run() {
		while(true){
			consumer.removeCount();
		}
	}
	
}
