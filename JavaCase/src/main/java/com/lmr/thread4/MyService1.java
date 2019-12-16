package com.lmr.thread4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService1 {
	
	private Lock lock=new ReentrantLock();
	
	public void method(String s){
//		lock.lock();
//		for(int i=1;i<=3;i++){
//			System.out.println(s+" - - "+i);
//		}
//		lock.unlock();
		
		try {
			lock.lock();
			for(int i=1;i<=3;i++){
				System.out.println(s+" - - "+i);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}
