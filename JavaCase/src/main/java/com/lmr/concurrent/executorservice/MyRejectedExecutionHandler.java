package com.lmr.concurrent.executorservice;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejectedExecutionHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		
		System.out.println(((MyRunnable1)r).getS()+" is rejectd run !");
		
	}

}
