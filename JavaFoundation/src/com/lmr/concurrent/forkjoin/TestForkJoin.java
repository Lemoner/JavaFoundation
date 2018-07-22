package com.lmr.concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class TestForkJoin {

	public static void main(String[] args) {
		
		TestForkJoin test=new TestForkJoin();
		
//		test.TestOne();
		test.TestTwo();
//		test.TestThree();
		
	}

	private void TestThree() {
		
		ForkJoinPool pool=new ForkJoinPool();
		
		MyRecursiveTask task=new MyRecursiveTask(0, 30);
		
		pool.submit(task);
		
		System.out.println(task.join());
		
	}

	private void TestTwo() {
		
		ForkJoinPool pool=new ForkJoinPool();
		
		MyRecursiveTask1 task=new MyRecursiveTask1();
		pool.submit(task);
		pool.shutdown();
		System.out.println(System.currentTimeMillis());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			System.out.println(task.get()+" - "+System.currentTimeMillis());
			System.out.println(task.join()+" - "+System.currentTimeMillis());
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
		System.out.println("END");
	}

	private void TestOne() {
		
		ForkJoinPool pool=new ForkJoinPool();
		
		pool.submit(new MyRecursiveAction(1, 10));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
