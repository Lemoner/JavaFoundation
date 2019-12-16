package com.lmr.thread4;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class MyService5 {
	
	private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
	private ReadLock readLock=readWriteLock.readLock(); 
	private WriteLock writeLock=readWriteLock.writeLock();
	
	public void ReadMethod(){
		try {
			readLock.lock();
			System.out.println(Thread.currentThread().getName()+" is read "+System.currentTimeMillis());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}
	}
	
	public void WriteMethod(){
		try {
			writeLock.lock();
			System.out.println(Thread.currentThread().getName()+" is write "+System.currentTimeMillis());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
	}
	
}
