package com.lmr.concurrent.semaphore;

public class TestSemaphore {

	public void TestOne() {

		MyService1 service = new MyService1();

		MyThread1 thread1 = new MyThread1(service);
		thread1.setName("MyThread1");
		MyThread1 thread2 = new MyThread1(service);
		thread2.setName("MyThread2");
		MyThread1 thread3 = new MyThread1(service);
		thread3.setName("MyThread3");
		MyThread1 thread4 = new MyThread1(service);
		thread4.setName("MyThread4");
		MyThread1 thread5 = new MyThread1(service);
		thread5.setName("MyThread5");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();

	}

	public void TestTwo() {

		MyService2 service = new MyService2();
		MyThread2 thread1 = new MyThread2(service);
		thread1.setName("MyThread1");
		MyThread2 thread2 = new MyThread2(service);
		thread2.setName("MyThread2");

		thread1.start();
		thread2.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// thread1.interrupt();
		thread2.interrupt();

	}

	public void TestThree() {

		MyService3 service = new MyService3();
		MyThread3 thread1 = new MyThread3(service);
		thread1.setName("MyThread1");
		MyThread3 thread2 = new MyThread3(service);
		thread2.setName("MyThread2");

		thread1.start();
		thread2.start();

	}

	public void TestFour() {

		MyService4 service = new MyService4();

		MyThread4[] threads = new MyThread4[5];
		for (int i = 0; i < threads.length; i++) {
			MyThread4 thread = new MyThread4(service);
			thread.setName("MyThread_" + (i + 1));
			threads[i] = thread;
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}

	}

	public void TestPC() {

		MyServicePC servicePC = new MyServicePC();

		MyThreadP[] threadPs = new MyThreadP[100];
		MyThreadC[] threadCs = new MyThreadC[100];

		for (int i = 0; i < 100; i++) {
			threadPs[i] = new MyThreadP(servicePC);
			threadPs[i].setName("MyThreadP-" + (i + 1));
			threadCs[i] = new MyThreadC(servicePC);
			threadCs[i].setName("MyThreadC-" + (i + 1));
		}

		for (int i = 0; i < 100; i++) {
			threadPs[i].start();
			threadCs[i].start();
		}

	}

	public static void main(String[] args) {

		TestSemaphore test = new TestSemaphore();

//		 test.TestOne();
		// test.TestTwo();
		 test.TestThree();
		// test.TestFour();
//		test.TestPC();

	}

}
