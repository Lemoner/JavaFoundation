package com.lmr.thread_pc;

public class Product2 {

	private Object plock;
	private Object clock;
	
	public Product2(Object plock, Object clock) {
		this.plock=plock;
		this.clock=clock;
	}
	
	public void addCount(){
		try {
			synchronized (plock) {
				while(ValueObject.count>0){
					System.out.println("Product lock.wait() ++++++++++");
					plock.wait();
				}
			}
			synchronized(clock){
				System.out.println("add "+ValueObject.count+" "+System.currentTimeMillis());
				ValueObject.count++;
				clock.notify();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
