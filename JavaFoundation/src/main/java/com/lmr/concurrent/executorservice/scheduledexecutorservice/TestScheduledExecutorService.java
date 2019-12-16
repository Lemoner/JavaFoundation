package com.lmr.concurrent.executorservice.scheduledexecutorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestScheduledExecutorService {

	public static void main(String[] args) {
		
		TestScheduledExecutorService test=new TestScheduledExecutorService();
		
//		test.TestOne();
		test.TestTwo();
		
	}

	private void TestTwo() {
		
		ScheduledThreadPoolExecutor executor=new ScheduledThreadPoolExecutor(1);
		
		MyRunnable runnable1=new MyRunnable("MyRunnable_1",1000);
//		MyRunnable runnable2=new MyRunnable("MyRunnable_2",500);
		
//		executor.scheduleAtFixedRate(runnable1, 0, 1000, TimeUnit.MILLISECONDS);
//		executor.scheduleAtFixedRate(runnable2, 0, 1000, TimeUnit.MILLISECONDS);
		
		executor.scheduleWithFixedDelay(runnable1, 0, 500, TimeUnit.MILLISECONDS);
//		executor.scheduleWithFixedDelay(runnable2, 0, 500, TimeUnit.MILLISECONDS);
		
//		while(true){
//			System.out.println(executor.getQueue().size());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}

	private void TestOne() {
		
//		ScheduledExecutorService executor=Executors.newScheduledThreadPool(1);
		ScheduledThreadPoolExecutor executor=new ScheduledThreadPoolExecutor(1);
		
		MyCallable callable1=new MyCallable("MyCallable_1");
		MyCallable callable2=new MyCallable("MyCallable_2");
		MyCallable callable3=new MyCallable("MyCallable_3");
		
		ScheduledFuture<String> future1=executor.schedule(callable1, 1000, TimeUnit.MILLISECONDS);
		ScheduledFuture<String> future2=executor.schedule(callable2, 2000, TimeUnit.MILLISECONDS);
		ScheduledFuture<String> future3=executor.schedule(callable3, 2000, TimeUnit.MILLISECONDS);
		
//		MyRunnable runnable1=new MyRunnable("MyRunnable_1");
//		MyRunnable runnable2=new MyRunnable("MyRunnable_2");
//		
//		ScheduledFuture<String> future1=(ScheduledFuture<String>) executor.schedule(runnable1, 1000, TimeUnit.MILLISECONDS);
//		ScheduledFuture<String> future2=(ScheduledFuture<String>) executor.schedule(runnable2, 2000, TimeUnit.MILLISECONDS);
		
		try {
			System.out.println("All is start "+System.currentTimeMillis());
			System.out.println(executor.getQueue().size());
			System.out.println(future1.get());
			System.out.println(executor.getQueue().size());
			System.out.println(future2.get());
			System.out.println(executor.getQueue().size());
			System.out.println(future3.get());
			System.out.println(executor.getQueue().size());
			System.out.println("All is end "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
