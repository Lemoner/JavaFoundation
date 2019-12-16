package com.lmr.thread3;

public class MyThread5 extends Thread{
	
	@Override
	public void run() {
		try {
			synchronized (this) {
				System.out.println("MyThread5 is start ...");
				for(int i=1;i<=10;i++){
					System.out.println("MyThread5 "+i+" "+System.currentTimeMillis());
					Thread.sleep(500);
				}
				System.out.println("MyThread5 is end ...");
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
