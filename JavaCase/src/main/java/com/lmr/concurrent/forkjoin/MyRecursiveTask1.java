package com.lmr.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask1 extends RecursiveTask<Integer>{

	
	
	@Override
	protected Integer compute() {
		System.out.println("MyRecursiveTask is run");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("MyRecursiveTask end");
//		int a=10/0;
		String s=null;
		s.toString();
		return 999999;
	}

}
