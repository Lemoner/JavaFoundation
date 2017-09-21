package com.lmr.thread5_7;

public class TestThread {
	
	public void TestOne(){
		
		MyThread1 mythread1=new MyThread1("MyThread1");
		MyThread1 mythread2=new MyThread1("MyThread2");
		
		ThreadGroup group=new ThreadGroup("ThreadGroup");
		
		Thread thread1=new Thread(group, mythread1);
		Thread thread2=new Thread(group, mythread2);
		
//		mythread1.start();
//		mythread2.start();
		
		thread1.start();
		thread2.start();
		
//		Thread allgroupthread=new Thread(group, "allgroupthread");
//		allgroupthread.start();
		
		System.out.println(group.getName()+" - - "+group.activeCount());
		
	}

	public static void main(String[] args) {
		
		TestThread test=new TestThread();
		
		test.TestOne();
		
	}
	
}
