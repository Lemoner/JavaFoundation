package com.lmr.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class MyService2 {

	private Semaphore semaphore = new Semaphore(1);

	public void method() {

		// semaphore.acquire();
		semaphore.acquireUninterruptibly();
		System.out.println(Thread.currentThread().getName() + " is acquire " + System.currentTimeMillis());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " is end " + System.currentTimeMillis());
		semaphore.release();

	}

}
