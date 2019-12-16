package com.lmr.concurrent_art;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TestAbstractQueuedSynchronizer {

	public static void main(String[] args) {
		
		TestAbstractQueuedSynchronizer test=new TestAbstractQueuedSynchronizer();
		
		test.TestOne();
		
	}

	private void TestOne() {
		
		final Lock lock=new TwinLock();
		
		class WorkThread extends Thread{
			@Override
			public void run() {
				while(true){
					lock.lock();
					try {
						SleepUtils.second(1);
						System.out.println(Thread.currentThread().getName());
						SleepUtils.second(1);
					} finally {
						lock.unlock();
					}
				}
			}
		}
		
		for(int i=1;i<=10;i++){
			WorkThread thread=new WorkThread();
			thread.setName("Thread - "+i);
			thread.setDaemon(true);
			thread.start();
		}
		
		for(int i=0;i<10;i++){
			SleepUtils.second(1);
			System.out.println("-----"+(i+1)+"-----");
		}
		System.out.println("END");
		
	}
	
}

class TwinLock implements Lock{
	
	private final Sync sync=new Sync(2);
	
	private static final class Sync extends AbstractQueuedSynchronizer{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -7221664007486855584L;

		public Sync(int count) {
			if(count<=0){
				throw new IllegalArgumentException("count must large than zero");
			}
			setState(count);
		}
		 
		@Override
		protected int tryAcquireShared(int reduceCount) {
			for(;;){
				int currentCount=getState();
				int newCount=currentCount-reduceCount;
				if(newCount>=0&&compareAndSetState(currentCount, newCount)){
					return newCount;
				}
			}
		}

		@Override
		protected boolean tryReleaseShared(int addCount) {
			for(;;){
				int currentCount=getState();
				int newCount=currentCount+addCount;
				if(compareAndSetState(currentCount, newCount)){
					return true;
				}
			}
		}
		
	}
	
	@Override
	public void lock() {
		sync.acquireShared(1);
	}
	
	@Override
	public void unlock() {
		sync.releaseShared(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}