package com.lmr.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadOrderRunTest {

	public static void main(String[] args) throws InterruptedException {
		
//		for(int i=0;i<10;i++){
//			OrderRunnable or=new OrderRunnable(i);
//乱序
//			new Thread(or).start();
//先join的先执行，结果顺序执行
//			Thread t=new Thread(or);
//			t.start();
//			try {
//				t.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
//		BlockingQueue<OrderRunnable> queue=new ArrayBlockingQueue<>(5);
//		new Thread(new AddQueue(queue)).start();
//		Thread.sleep(100);
//		for(int i=0;i<5;i++){
//			new Thread(new PutQueue(queue)).start();
//		}
		
//		for(int i=0;i<10;i++){
//			OrderCallable oc=new OrderCallable(i);
//			FutureTask<Integer> result=new FutureTask<>(oc);
//			new Thread(result).start();
//			while(result.isDone()){
//				Thread.sleep(10);
//				try {
//					System.out.println(i+" - - "+result.get());
//				} catch (ExecutionException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			try {
//				System.out.println(i+" - - "+result.get());
//			} catch (ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		ExecutorService exector=Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			OrderCallable oc=new OrderCallable(i);
			FutureTask<Integer> result=new FutureTask<>(oc);
			exector.submit(result);
		}
		exector.shutdown();
		
	}
	
}

class AddQueue implements Runnable{
	BlockingQueue<OrderRunnable> queue;
	public AddQueue(BlockingQueue<OrderRunnable> queue) {
		// TODO Auto-generated constructor stub
		this.queue=queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < 100; i++) {
				OrderRunnable or = new OrderRunnable(i);
				queue.put(or);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class PutQueue implements Runnable{

	BlockingQueue<OrderRunnable> queue;
	public PutQueue(BlockingQueue<OrderRunnable> queue) {
		// TODO Auto-generated constructor stub
		this.queue=queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!queue.isEmpty()){
			try {
				Thread t=new Thread(queue.take());
				t.start();
//				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class OrderRunnable implements Runnable{

	private int index;
	private static Object lock=new Object();
	
	public OrderRunnable(int index) {
		// TODO Auto-generated constructor stub
		this.index=index;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		process();
		
		synchronized (lock) {
//			lock.notify();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("index : "+index);
//			try {
//				lock.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}
	
	public synchronized void process(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("index : "+index);
	}
	
}

class OrderCallable implements Callable<Integer>{

	private int index;
	private int result=0;
	
	public OrderCallable(int index){
		this.index=index;
	}
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("index : "+index);
		result=1;
		return result;
	}
	
}
