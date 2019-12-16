package com.lmr.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

public class ControlTaskGroupTest {

	public static void main(String[] args) {
		
		List<Callable<Integer>> callablelist=new ArrayList<>();
//		List<Future<Integer>> tasklist=new ArrayList<>();
//		
//		Future<Integer> singletask;
		
		Random rand=new Random();
		
		for(int i=1;i<10;i++){
			Callable<Integer> callable=new SumCallable(i, i+10, (rand.nextInt(10)+1)*100);//随机生成线程休息时间数，便于识别线程执行的进度
			callablelist.add(callable);
		}
		
		ExecutorService executor=Executors.newCachedThreadPool();
		
//		try {
//			System.out.println(executor.invokeAny(callablelist));//返回callablelist中某个已经完成了的任务的结果
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			tasklist=executor.invokeAll(callablelist);//返回一个Future对象的列表，代表所有任务的解决方案，当返回时，所有任务已全部完成，且结果是有序的（但比较耗时，须等待所有任务全部完成）
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		for(Future<Integer> task:tasklist){
//			try {
//				System.out.println(" ---------------- "+task.get());
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		@SuppressWarnings("rawtypes")
		ExecutorCompletionService service=new ExecutorCompletionService(executor);//完成服务执行器，提交任务
		for(Callable<Integer> callable:callablelist){
			service.submit(callable);
		}
		for(int i=0;i<callablelist.size();i++){
			try {
				System.out.println(service.take().get());//当任务完成时，有结果就返回，无须等待全部任务完成，但结果没顺序
				//take()取出下一个已完成的结果，若无结果可用则阻塞
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class SumCallable implements Callable<Integer>{

	private int start;
	private int end;
	private int sleeptime;//线程休息时间
	private int result;
	
	public SumCallable(int start,int end,int sleeptime) {
		// TODO Auto-generated constructor stub
		this.start=start;
		this.end=end;
		this.sleeptime=sleeptime;
	}
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		result=0;
		for(int i=start;i<=end;i++){
			result+=i;
			Thread.sleep(sleeptime);
		}
		System.out.println("start: "+start+" end: "+end+" sleeptime: "+sleeptime+" result: "+result);
		return result;
	}
	
}
