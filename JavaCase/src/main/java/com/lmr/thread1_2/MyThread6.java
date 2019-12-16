package com.lmr.thread1_2;

public class MyThread6 extends Thread{

	private String u;
	public static int count;
	
	public MyThread6(String u) {
		this.u=u;
	}
	
	@Override
	public void run() {
		synchronized (MyThread6.class) {
			for(int i=0;i<100;i++){
				count++;
			}
			System.out.println(u+" - - "+count);
		}
	}
	
}
