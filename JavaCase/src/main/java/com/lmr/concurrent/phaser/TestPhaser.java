package com.lmr.concurrent.phaser;

public class TestPhaser {

	public void TestOne() {

		MyService1 service = new MyService1();

		for (int i = 0; i < 3; i++) {
			MyThread1 thread = new MyThread1(service, String.valueOf((char) ('A' + i)));
			thread.setName("Thread" + (i + 1));
			thread.start();
		}

	}

	public void TestTwo() {

		MyService2 service = new MyService2();

		for (int i = 0; i < 3; i++) {
			MyThread2 thread = new MyThread2(service, String.valueOf((char) ('A' + i)));
			thread.setName("Thread" + (i + 1));
			thread.start();
		}

	}
	
	public void TestThree(){
		
		MyService3 service=new MyService3();
		
		for(int i=0;i<3;i++){
			MyThread3 thread=new MyThread3(service, String.valueOf((char) ('A' + i)));
			thread.setName("Thread" + (i + 1));
			thread.start();
		}
		
	}

	public static void main(String[] args) {

		TestPhaser test = new TestPhaser();

//		test.TestOne();
		test.TestTwo();
//		test.TestThree();

	}

}
