package com.lmr.thread4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService3 {
	
	private Lock lock=new ReentrantLock();
	private Condition conditiona=lock.newCondition();
	private Condition conditionb=lock.newCondition();
	private Condition conditionc=lock.newCondition();
	
	public void await(String s){
		try {
			lock.lock();
			System.out.println(s+" await "+System.currentTimeMillis());
			if("A".equals(s)){
				conditiona.await();
			}
			else if("B".equals(s)){
				conditionb.await();
			}
			else if("C".equals(s)){
				conditionc.await();
			}
			System.out.println(s+" await end "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void signal(String s){
		try {
			lock.lock();
			System.out.println(s+" signal "+System.currentTimeMillis());
			if("A".equals(s)){
				conditiona.signal();
			}
			else if("B".equals(s)){
				conditionb.signal();
			}
			else if("C".equals(s)){
				conditionc.signal();
			}
			System.out.println(s+" signal end "+System.currentTimeMillis());
		} finally {
			lock.unlock();
		}
	}
	
}
