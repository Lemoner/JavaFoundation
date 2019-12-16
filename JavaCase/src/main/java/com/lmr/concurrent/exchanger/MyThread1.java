package com.lmr.concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class MyThread1 extends Thread {

	private Exchanger<String> exchanger;

	public MyThread1(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			System.out.println("MyThread1 is take " + exchanger.exchange("AAA"));
			System.out.println("MyThread1 is end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
