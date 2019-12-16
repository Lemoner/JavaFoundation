package com.lmr.thread3;

public class MyThread7 extends Thread{

	private MyThread6 thread;
	
	public MyThread7(MyThread6 thread) {
		this.thread=thread;
	}
	
	@Override
	public void run() {
		try {
			synchronized (thread) {
				thread.start();
//				thread.join();
				thread.join(1000);
				
				System.out.println("MyThread7 is start ... "+System.currentTimeMillis());
				for(int i=20;i<=25;i++){
					System.out.println("MyThread7 "+i+" "+System.currentTimeMillis());
					Thread.sleep(500);
				}
				System.out.println("MyThread7 is end ... "+System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
