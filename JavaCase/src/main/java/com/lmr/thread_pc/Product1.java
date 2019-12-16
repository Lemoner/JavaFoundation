package com.lmr.thread_pc;

public class Product1 {

	private Object lock;
	
	public Product1(Object lock) {
		this.lock=lock;
	}
	
	public void addCount(){
		try {
			synchronized(lock){
				while(ValueObject.count>0){
					System.out.println("Product lock.wait() ++++++++++");
					lock.wait();
				}
				System.out.println("add "+ValueObject.count+" "+System.currentTimeMillis());
				ValueObject.count++;
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
