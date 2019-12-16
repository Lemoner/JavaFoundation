package com.lmr.thread3;

public class MyThread3 extends Thread{

	private String u;
	private Object lock;
	
	public MyThread3(Object lock, String u) {
		this.lock=lock;
		this.u=u;
	}
	
	@Override
	public void run() {
		try {
			synchronized (lock) {
				if("*".equals(u)){
//					lock.notify();
					lock.notifyAll();
				}
				else{
					System.out.println("start "+u+" "+System.currentTimeMillis());
					lock.wait();
					System.out.println("end "+u+" "+System.currentTimeMillis());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
