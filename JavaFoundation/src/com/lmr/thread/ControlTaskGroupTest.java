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
			Callable<Integer> callable=new SumCallable(i, i+10, (rand.nextInt(10)+1)*100);//��������߳���Ϣʱ����������ʶ���߳�ִ�еĽ���
			callablelist.add(callable);
		}
		
		ExecutorService executor=Executors.newCachedThreadPool();
		
//		try {
//			System.out.println(executor.invokeAny(callablelist));//����callablelist��ĳ���Ѿ�����˵�����Ľ��
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			tasklist=executor.invokeAll(callablelist);//����һ��Future������б�������������Ľ��������������ʱ������������ȫ����ɣ��ҽ��������ģ����ȽϺ�ʱ����ȴ���������ȫ����ɣ�
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
		ExecutorCompletionService service=new ExecutorCompletionService(executor);//��ɷ���ִ�������ύ����
		for(Callable<Integer> callable:callablelist){
			service.submit(callable);
		}
		for(int i=0;i<callablelist.size();i++){
			try {
				System.out.println(service.take().get());//���������ʱ���н���ͷ��أ�����ȴ�ȫ��������ɣ������û˳��
				//take()ȡ����һ������ɵĽ�������޽������������
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
	private int sleeptime;//�߳���Ϣʱ��
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
