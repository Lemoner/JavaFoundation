package com.lmr.concurrent.completionservice;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	private String s;
	private int t;
	
	public MyCallable(String s, int t){
		this.s=s;
		this.t=t;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(s+" is run ! "+System.currentTimeMillis());
		
		Thread.sleep(t);
		
		return s+"~end";
	}

}
