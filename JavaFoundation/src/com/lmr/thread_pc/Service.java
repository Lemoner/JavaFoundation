package com.lmr.thread_pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {
	
	private ReentrantLock lock=new ReentrantLock(true);
	private Condition condition=lock.newCondition();
	private boolean hasValue=false;
	
	public void set(){
		try {
			lock.lock();
			while(hasValue){
				System.out.println(Thread.currentThread().getName()+" set condition await . . .");
				condition.await(); 
			}
			hasValue=true;
			System.out.println(Thread.currentThread().getName()+" set hasValue + + "+hasValue);
			condition.signal();
//			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void get(){
		try {
			lock.lock();
			while(!hasValue){
				System.out.println(Thread.currentThread().getName()+" get condition await . . .");
				condition.await();
			}
			hasValue=false;
			System.out.println(Thread.currentThread().getName()+" get hasValue - - "+hasValue+" "+lock.isLocked());
			condition.signal();
//			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}
