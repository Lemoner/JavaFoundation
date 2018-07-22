package com.lmr.concurrent_art;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestFairAndUnFair {

	public static void main(String[] args) {
		
		TestFairAndUnFair test=new TestFairAndUnFair();
		
		test.TestOne();
		
	}

	public void TestOne() {
		
		Lock fairLock=new ReLock(true);
		Lock unfairLock=new ReLock(false);
		
		for(int i=1;i<=10;i++){
			Work thread=new Work(unfairLock);
			thread.setName(""+i);
			thread.setDaemon(true);
			thread.start();
		}
		
		for(int i=0;i<20;i++){
			SleepUtils.second(1);
			System.out.println("-----"+(i+1)+"-----");
		}
		System.out.println("END");
		
	}
	
	class Work extends Thread{

		private Lock lock;
		
		public Work(Lock lock) {
			this.lock=lock;
		}
		
		@Override
		public void run() {
			while(true){
				lock.lock();
				try {
					SleepUtils.second(1);
					System.out.println(((ReLock) lock).getOwner().getName()+" - - "+((ReLock) lock).getQueueThreadsName().toString());
				} finally {
					lock.unlock();
				}
			}
		}
		
	}
	
	class ReLock extends ReentrantLock{
		public ReLock(boolean fair) {
			super(fair);
		}
		public ArrayList<Thread> getQueueThreads(){
			return new ArrayList<>(super.getQueuedThreads());
		}
		public ArrayList<String> getQueueThreadsName(){
			ArrayList<String> list=new ArrayList<>();
			for(Thread thread:getQueuedThreads()){
				list.add(0,thread.getName());
			}
			return list;
		}
		public Thread getOwner(){
			return super.getOwner();
		}
	}
	
}
