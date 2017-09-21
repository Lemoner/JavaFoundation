package com.lmr.concurrent.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyThread2 extends Thread {

	private String s;
	private Exchanger<String> exchanger;

	public MyThread2(Exchanger<String> exchanger, String s) {
		this.exchanger = exchanger;
		this.s=s;
	}

	@Override
	public void run() {
		try {
//			System.out.println(Thread.currentThread().getName()+" is exchange "+s+" to " + exchanger.exchange(s));
			System.out.println(Thread.currentThread().getName()+" is exchange "+s+" to " + exchanger.exchange(s,2,TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
