package com.lmr.thread3;

public class MyThread4 extends Thread{

	private MyThread5 threadlock;
	
	public MyThread4(MyThread5 threadlock) {
		this.threadlock=threadlock;
	}
	
	@Override
	public void run() {
		try {
			synchronized (threadlock) {
				System.out.println("MyThread4 is start ...");
				for(int i=1;i<=10;i++){
					System.out.println("MyThread4 "+i+" "+System.currentTimeMillis());
					Thread.sleep(500);
					if(i==5){
						threadlock.start();
						threadlock.join();
					}
				}
				System.out.println("MyThread4 is end ...");
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
