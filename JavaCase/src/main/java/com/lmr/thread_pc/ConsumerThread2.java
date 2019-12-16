package com.lmr.thread_pc;

public class ConsumerThread2 extends Thread{

	private Consumer2 consumer;
	
	public ConsumerThread2(Consumer2 consumer) {
		this.consumer=consumer;
	}
	
	@Override
	public void run() {
		while(true){
			consumer.removeCount();
		}
	}
	
}
