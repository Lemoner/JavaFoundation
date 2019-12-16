package com.lmr.concurrent.countdownlatch;

public class TestCountDownLatch {

	public void TestOne(){
		
		MyService1 service=new MyService1();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				service.end();
			}
		}).start();
		
		for(int i=0;i<5;i++){
			MyThread1 thread=new MyThread1(service);
			thread.setName("Thread_"+(i+1));
			thread.start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void TestTwo(){
		
		MyService2 service=new MyService2();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				service.end();
			}
		}).start();
		
		for(int i=0;i<10;i++){
			MyThread2 thread=new MyThread2(service);
			thread.setName("Thread_"+(i+1));
			thread.start();
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}
	
	public void TestThree(){
		
		MyService3 service=new MyService3();
		
		for(int i=0;i<10;i++){
			MyThread3 thread=new MyThread3(service);
			thread.setName("Thread_"+(i+1));
			thread.start();
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.init();
		
	}
	
	public static void main(String[] args) {
		
		TestCountDownLatch test=new TestCountDownLatch();
		
//		test.TestOne();
//		test.TestTwo();
		test.TestThree();
		
	}
	
}
