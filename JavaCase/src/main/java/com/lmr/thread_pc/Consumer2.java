package com.lmr.thread_pc;

public class Consumer2 {

	private Object plock;
	private Object clock;
	
	public Consumer2(Object plock, Object clock) {
		this.plock=plock;
		this.clock=clock;
	}
	
	public void removeCount(){
		try {
			synchronized (clock) {
				while(ValueObject.count<=0){
					System.out.println("Consumer lock.wait() ----------");
					clock.wait();
				}
			}
			synchronized (plock) {
				if(ValueObject.count>0){
					System.out.println("remove "+ValueObject.count+" "+System.currentTimeMillis());
					ValueObject.count--;
					plock.notify();
				}
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
