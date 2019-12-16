package com.lmr.thread4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService2 {
	
	private Lock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	
	public void await(String s){
		try {
			lock.lock();
			System.out.println(s+" await "+System.currentTimeMillis());
			condition.await();
			System.out.println(s+" await end "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void signal(){
		try {
			lock.lock();
			System.out.println("signal "+System.currentTimeMillis());
//			condition.signal();
			condition.signalAll();
			System.out.println("signal end "+System.currentTimeMillis());
		} finally {
			lock.unlock();
		}
	}
	
}
