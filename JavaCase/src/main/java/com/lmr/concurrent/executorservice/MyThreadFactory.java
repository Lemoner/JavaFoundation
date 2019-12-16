package com.lmr.concurrent.executorservice;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		
		Thread thread=new Thread(r);
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				
				System.out.println(t.getName()+" - "+e.getMessage());
				
			}
		});
		
		return thread;
	}

}
