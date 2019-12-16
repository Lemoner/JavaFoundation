package com.lmr.thread3;

public class MyThread8 extends Thread{

	private MyThread6 thread;
	
	public MyThread8(MyThread6 thread) {
		this.thread=thread;
	}
	
	@Override
	public void run() {
		thread.method();
	}

}
