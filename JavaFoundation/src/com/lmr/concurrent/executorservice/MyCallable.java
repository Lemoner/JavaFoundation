package com.lmr.concurrent.executorservice;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	private String name;
	private int sleeptime;
	private boolean isthrow;
	
	public MyCallable(String name, int sleeptime, boolean isthrow){
		this.name=name;
		this.sleeptime=sleeptime;
		this.isthrow=isthrow;
	}
	
	@Override
	public String call() throws Exception {
		
		System.out.println(name + " is run " + System.currentTimeMillis());
		Thread.sleep(sleeptime);
		if (isthrow) {
			throw new Exception(name + " throws");
		}
		System.out.println(name+" is end "+System.currentTimeMillis());
		
		return name;
	}

}
