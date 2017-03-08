package com.lmr.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Callable_Future_1 {

	public static void main(String[] args) {
		
//		ExecutorService exector=Executors.newCachedThreadPool();
//		Callable_1 callable1=new Callable_1();
//		Future<Integer> result=exector.submit(callable1);
//		exector.shutdown();//线程执行后，不能再往线程池中添加新线程，知道线程池中的所有线程执行完成后，退出
//		
//		ExecutorService exector=Executors.newCachedThreadPool();
//		Callable_1 callable1=new Callable_1();
//		FutureTask<Integer> result=new FutureTask<>(callable1);
//		exector.submit(result);
		
		Callable_1 callable1=new Callable_1();
		FutureTask<Integer> result=new FutureTask<>(callable1);
		new Thread(result).start();//启动result的FutureTask对象,去执行callable1的call方法
		
		System.out.println("main thread is running");
		
		try {
			System.out.println("result: "+result.get());//获取结果
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		while(true){
//			try {
//				System.out.println("result: "+result.get()+"  "+result.isDone());
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		System.out.println("main thread is ending");
		
	}
	
}
