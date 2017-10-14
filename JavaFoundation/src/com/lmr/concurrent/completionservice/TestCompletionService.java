package com.lmr.concurrent.completionservice;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestCompletionService {

	public static void main(String[] args) {
		
		TestCompletionService test=new TestCompletionService();
		
//		test.TestOne();
		test.TestTwo();
		
	}

	private void TestTwo() {
		
		ExecutorService service=Executors.newCachedThreadPool();
		CompletionService completionService=new ExecutorCompletionService<>(service); 
		
		for(int i=1;i<6;i++){
			MyCallable callable=new MyCallable("MyCallable"+i, i*1000);
			completionService.submit(callable);
		}
		
		for(int i=1;i<7;i++){
			try {
				System.out.println("wait "+i+" result "+System.currentTimeMillis());
//				Thread.sleep(1000);
//				Future future=completionService.poll();
				Future future=completionService.poll(1000,TimeUnit.MILLISECONDS);
				if(future!=null){
					System.out.println(future.get()+" "+System.currentTimeMillis());
				}
				else{
					System.out.println(future+" "+System.currentTimeMillis());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("All is end !");
		
	}

	private void TestOne() {
		
		ExecutorService service=Executors.newCachedThreadPool();
		CompletionService completionService=new ExecutorCompletionService<>(service); 
		
		for(int i=1;i<6;i++){
			MyCallable callable=new MyCallable("MyCallable"+i, i*1000);
			completionService.submit(callable);
		}
		
		for(int i=1;i<7;i++){
			try {
				System.out.println("wait "+i+" result "+System.currentTimeMillis());
				System.out.println(completionService.take().get()+" "+System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("All is end !");
		
	}
	
}
