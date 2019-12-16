package com.lmr.thread;

public class TestSynchronized2 {

	public static void main(String[] args) {
		TxtThread tt = new TxtThread();
		new Thread(tt).start();
		new Thread(tt).start();
		new Thread(tt).start();
		new Thread(tt).start();
	}
}

class TxtThread implements Runnable {
	int num = 50;
	int count=1;
	String str = new String();

	public void run() {
		synchronized (str) {
			System.out.println(count++);
			while (num > 0) {
//				System.out.println(count++);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.getMessage();
				}
				System.out.println(Thread.currentThread().getName() + " this is " + num--);
			}
		}
	}
}
