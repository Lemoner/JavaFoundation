package com.lmr.thread4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService4 {
	
	private Lock lock=new ReentrantLock(true);
	
	public void method(){
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName()+" is get lock");
		} finally {
			lock.unlock();
		}
	}
	
}
