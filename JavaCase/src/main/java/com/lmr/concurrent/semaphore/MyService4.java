package com.lmr.concurrent.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService4 {

	private int MaxSize=3;
	private int permits=3;
	private List<String> list=new ArrayList<>();
	private Semaphore semaphore=new Semaphore(permits);
	private ReentrantLock lock=new ReentrantLock(true);
	private Condition condition=lock.newCondition();
	
	public MyService4(){
		
		for(int i=1;i<=MaxSize;i++){
			list.add("NUM_"+i);
		}
		
	}
	
	public String get(){
		String value = null;
		
		try {
			semaphore.acquire();
			
			lock.lock();
			while(list.size()==0){
				condition.await();
			}
			value=list.remove(0);
			lock.unlock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return value;
	}
	
	public void put(String value){
		
		lock.lock();
		list.add(value);
		condition.signalAll();
//		condition.signal();
		lock.unlock();
		semaphore.release();
	}
	
}
