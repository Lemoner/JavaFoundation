package com.lmr.concurrent.executorservice.scheduledexecutorservice;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	private String s;
	
	public MyCallable(String s){
		this.s=s;
	}
	
	@Override
	public String call() throws Exception {
		
		System.out.println(s+" is run "+System.currentTimeMillis());
		
		return s;
	}

}
