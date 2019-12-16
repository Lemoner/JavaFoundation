package com.lmr.thread4;

public class TestThread {

	public void TestThread1(){
		
		MyService1 service=new MyService1();
		MyThread1 thread1=new MyThread1(service, "A");
		MyThread1 thread2=new MyThread1(service, "B");
		MyThread1 thread3=new MyThread1(service, "C");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
	
	public void TestThread2(){
		
		MyService2 service=new MyService2();
		MyThread2 thread1=new MyThread2(service, "A");
		MyThread2 thread2=new MyThread2(service, "B");
		MyThread2 thread3=new MyThread2(service, "C");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.signal();
		
	}
	
	public void TestThread3(){
		
		MyService3 service=new MyService3();
		MyThread3 thread1=new MyThread3(service, "A");
		MyThread3 thread2=new MyThread3(service, "B");
		MyThread3 thread3=new MyThread3(service, "C");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.signal("B");
		
	}
	
	public void TestThread4(){
		
		MyService4 service=new MyService4();
		
		for(int i=1;i<10;i++){
			MyThread4 thread=new MyThread4(service);
			thread.setName("thread"+i);
			thread.start();
		}
		
	}
	
	public void TestThread5(){
		
		MyService5 service=new MyService5();
		
		MyThread5 thread1=new MyThread5(service, "Read"); 
		thread1.setName("thread1_read");
		MyThread5 thread2=new MyThread5(service, "Read"); 
		thread2.setName("thread2_read");
		MyThread5 thread3=new MyThread5(service, "Write"); 
		thread3.setName("thread3_write");
		MyThread5 thread4=new MyThread5(service, "Write"); 
		thread4.setName("thread4_write");
		
		thread3.start();
		thread4.start();
		thread1.start();
		thread2.start();
		
	}
	
	public static void main(String[] args) {
		
		TestThread test=new TestThread();
		
//		test.TestThread1();
//		test.TestThread2();
//		test.TestThread3();
//		test.TestThread4();
		test.TestThread5();
		
	}
	
}
