package com.lmr.concurrent.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestExecutorService {

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
		
		executor.shutdown();
//		List<Runnable> list=executor.shutdownNow();
//		
//		for(Runnable runnable:list){
//			System.out.println(((MyRunnable1)runnable).getS());
//		}
		
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
		
//		try {
//			executor.awaitTermination(3, TimeUnit.SECONDS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(executor.getPoolSize()+" - "+executor.getQueue().size()+" - "+executor.getActiveCount()+" - "+System.currentTimeMillis());
		
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(executor.isShutdown()+" - "+executor.isTerminating()+" - "+executor.isTerminated());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(executor.isShutdown()+" - "+executor.isTerminating()+" - "+executor.isTerminated());
		
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(executor.isShutdown()+" - "+executor.isTerminating()+" - "+executor.isTerminated());
		
	}
	
	public void TestFive(){
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.SECONDS, new SynchronousQueue<>(), new MyThreadFactory());
		executor.setRejectedExecutionHandler(new MyRejectedExecutionHandler());

		for (int i = 0; i < 7; i++) {
			executor.execute(new MyRunnable1("Runnable" + (i + 1)));
		}
		
		executor.shutdown();
		
	}
	
	public void TestSix(){
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1), new ThreadPoolExecutor.DiscardOldestPolicy());

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

		TestExecutorService test = new TestExecutorService();

//		test.TestOne();
//		test.TestTwo();
//		test.TestThree();
//		test.TestFour();
		test.TestFive();
//		test.TestSix();
		
//		test.TestSeven();

	}

	private void TestSeven() {
		
		List<MyCallable> list=new ArrayList<>();
		list.add(new MyCallable("MyCallable1", 100, true));
		list.add(new MyCallable("MyCallable2", 200, false));
		list.add(new MyCallable("MyCallable3", 300, true));
		
		ExecutorService service=Executors.newCachedThreadPool();
		
		try {
//			System.out.println("the first end is "+service.invokeAny(list));
//			System.out.println("the first end is "+service.invokeAny(list, 50, TimeUnit.MILLISECONDS));
			
//			List<Future<String>> futures=service.invokeAll(list);
			List<Future<String>> futures=service.invokeAll(list, 250, TimeUnit.MILLISECONDS);
			System.out.println("all is end ");
			for(int i=0;i<futures.size();i++){
				try {
					System.out.println(futures.get(i).get());
					System.out.println();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					System.out.println("*/*");
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("+-+");
			e.printStackTrace();
		}		
	}

}
