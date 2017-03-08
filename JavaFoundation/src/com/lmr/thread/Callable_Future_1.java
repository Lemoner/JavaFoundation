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
//		exector.shutdown();//�߳�ִ�к󣬲��������̳߳���������̣߳�֪���̳߳��е������߳�ִ����ɺ��˳�
//		
//		ExecutorService exector=Executors.newCachedThreadPool();
//		Callable_1 callable1=new Callable_1();
//		FutureTask<Integer> result=new FutureTask<>(callable1);
//		exector.submit(result);
		
		Callable_1 callable1=new Callable_1();
		FutureTask<Integer> result=new FutureTask<>(callable1);
		new Thread(result).start();//����result��FutureTask����,ȥִ��callable1��call����
		
		System.out.println("main thread is running");
		
		try {
			System.out.println("result: "+result.get());//��ȡ���
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
