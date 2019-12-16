package com.lmr.concurrent_art;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

	public static void main(String[] args) {
		
		TestLock test=new TestLock();
		
		test.TestOne();
		
	}

	private void TestOne() {
		
		ReentrantLock lock=new ReentrantLock(false);
		lock.lock();
		
		lock.unlock();
		
		
	}
	
}
