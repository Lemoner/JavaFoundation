package com.lmr.thread;

public class TestThread1 {

	public static void main(String[] args) {
		
		MyThread1 mt1=new MyThread1("A");
		MyThread1 mt2=new MyThread1("B");
		MyThread1 mt3=new MyThread1("C");
		
		mt1.start();
		mt2.start();
		mt3.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-----------------------");
		
		MyRunnable1 r1=new MyRunnable1();
		Thread t1=new Thread(r1, "RA");
		Thread t2=new Thread(r1, "RB");
		Thread t3=new Thread(r1, "RC");
		
		t1.setPriority(8);
		t2.setPriority(4);
		t3.setPriority(2);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}
