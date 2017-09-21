package com.lmr.concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class TestExchanger {

	public void TestOne() {

		Exchanger<String> exchanger = new Exchanger<>();

		MyThread1 thread1 = new MyThread1(exchanger);
		thread1.start();

		System.out.println("Main is end");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyThread1 thread2 = new MyThread1(exchanger);
		thread2.start();

	}
	
	public void TestTwo(){
		
		Exchanger<String> exchanger=new Exchanger<>();
		
		MyThread2 thread1=new MyThread2(exchanger, "AAA");
		thread1.setName("MyThread1");
		MyThread2 thread2=new MyThread2(exchanger, "BBB");
		thread2.setName("MyThread2");
		MyThread2 thread3=new MyThread2(exchanger, "CCC");
		thread3.setName("MyThread3");
//		MyThread2 thread4=new MyThread2(exchanger, "DDD");
//		thread4.setName("MyThread4");
		
		thread1.start();
		thread2.start();
		thread3.start();
//		thread4.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(thread1.isAlive());
		System.out.println(thread2.isAlive());
		System.out.println(thread3.isAlive());
		
	}

	public static void main(String[] args) {

		TestExchanger test = new TestExchanger();

//		test.TestOne();
		test.TestTwo();

	}

}
