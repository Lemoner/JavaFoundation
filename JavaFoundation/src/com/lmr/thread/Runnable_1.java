package com.lmr.thread;

public class Runnable_1 implements Runnable{

	private int num=0;
	
	private Boolean flag = false;
	private Object lock=new Object();
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		
		if(flag){
			synchronized (lock) {
				lock.notify();
			}
		}
		
		this.flag = flag;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			synchronized (lock) {
			
				if(!flag){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(num++);
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	}

}
