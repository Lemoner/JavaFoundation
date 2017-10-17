package com.lmr.thread1_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class TestThread11 {

	public static void main(String[] args) {
		
		MyThread8 thread=new MyThread8();
		
//		ExecutorService service=Executors.newSingleThreadExecutor();
		
		ForkJoinPool service=new ForkJoinPool();
		
		service.submit(thread);
		
		System.out.println("end");
		
	}
	
}
