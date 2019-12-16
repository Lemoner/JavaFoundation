package com.lmr.thread_pc;

public class Consumer1 {

	private Object lock;
	
	public Consumer1(Object lock) {
		this.lock=lock;
	}
	
	public void removeCount(){
		try {
			synchronized (lock) {
				while(ValueObject.count<=0){
					System.out.println("Consumer lock.wait() ----------");
					lock.wait();
				}
				System.out.println("remove "+ValueObject.count+" "+System.currentTimeMillis());
				ValueObject.count--;
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
