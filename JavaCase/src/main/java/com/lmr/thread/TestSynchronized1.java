package com.lmr.thread;

public class TestSynchronized1 {
	public static void main(String[] args) {
		MyRunnable2 mr1=new MyRunnable2();
		MyRunnable2 mr2=new MyRunnable2();
		Thread t1=new Thread(mr1,"A");
		Thread t2=new Thread(mr2,"B");
		t1.start();
		t2.start();
	}
}
