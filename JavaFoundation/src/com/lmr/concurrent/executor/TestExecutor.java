package com.lmr.concurrent.executor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestExecutor {

	public void TestOne() {

		// ExecutorService service=Executors.newCachedThreadPool();
		ExecutorService service = Executors.newSingleThreadExecutor();

		// for(int i=0;i<5;i++){
		// service.execute(new MyRunnable1("Runnable"+(i+1)));
		// }

		service.execute(new MyRunnable1("Runnable1"));
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.execute(new MyRunnable1("Runnable2"));

	}

	public void TestTwo() {

//		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 100, TimeUnit.MILLISECONDS, new SynchronousQueue<>());

		for (int i = 0; i < 7; i++) {
			executor.execute(new MyRunnable1("Runnable" + (i + 1)));
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(executor.getPoolSize()+" - "+executor.getQueue().size()+" - "+executor.getActiveCount());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(executor.getPoolSize()+" - "+executor.getQueue().size()+" - "+executor.getActiveCount());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(executor.getPoolSize()+" - "+executor.getQueue().size()+" - "+executor.getActiveCount());
		
	}
	
	public void TestThree() {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

		for (int i = 0; i < 6; i++) {
			executor.execute(new MyRunnable1("Runnable" + (i + 1)));
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(executor.getPoolSize()+" - "+executor.getQueue().size()+" - "+executor.getActiveCount());
		
//		executor.shutdown();
		List<Runnable> list=executor.shutdownNow();
		
		for(Runnable runnable:list){
			System.out.println(((MyRunnable1)runnable).getS());
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(executor.getPoolSize()+" - "+executor.getQueue().size()+" - "+executor.getActiveCount());
		
	}
	
	public void TestFour() {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

		for (int i = 0; i < 6; i++) {
			executor.execute(new MyRunnable1("Runnable" + (i + 1)));
		}
		
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(executor.isShutdown()+" - "+executor.isTerminating()+" - "+executor.isTerminated());
		
		executor.shutdown();
//		executor.shutdownNow();
		
		try {
			executor.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(executor.getPoolSize()+" - "+executor.getQueue().size()+" - "+executor.getActiveCount()+" - "+System.currentTimeMillis());
		
//		try {
//			Thread.sleep(800);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(executor.isShutdown()+" - "+executor.isTerminating()+" - "+executor.isTerminated());
//
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(executor.isShutdown()+" - "+executor.isTerminating()+" - "+executor.isTerminated());
//		
//		try {
//			Thread.sleep(800);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(executor.isShutdown()+" - "+executor.isTerminating()+" - "+executor.isTerminated());
		
	}
	
	public void TestFive(){
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.SECONDS, new SynchronousQueue<>(), new MyThreadFactory());
		executor.setRejectedExecutionHandler(new MyRejectedExecutionHandler());

		for (int i = 0; i < 6; i++) {
			executor.execute(new MyRunnable1("Runnable" + (i + 1)));
		}
		
		executor.shutdown();
		
	}
	
	public void TestSix(){
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1), new ThreadPoolExecutor.DiscardOldestPolicy()){
			
			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				// TODO Auto-generated method stub
				super.afterExecute(r, t);
				System.out.println(((MyRunnable1)r).getS()+" is run end !");
			}
			
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				// TODO Auto-generated method stub
				super.beforeExecute(t, r);
				System.out.println(((MyRunnable1)r).getS()+" is start ...");
			}
		};

		for (int i = 0; i < 3; i++) {
			executor.execute(new MyRunnable1("Runnable" + (i + 1)));
		}
		
		try {
			Thread.sleep(1300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		executor.shutdown();
		
		System.out.println(executor.getPoolSize()+" - "+executor.getQueue().size()+" - "+executor.getActiveCount());
		
		for (int i = 3; i < 6; i++) {
			executor.execute(new MyRunnable1("Runnable" + (i + 1)));
			System.out.println(executor.getPoolSize()+" - "+executor.getQueue().size()+" - "+executor.getActiveCount());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		TestExecutor test = new TestExecutor();

//		test.TestOne();
//		test.TestTwo();
//		test.TestThree();
//		test.TestFour();
//		test.TestFive();
		test.TestSix();

	}

}
