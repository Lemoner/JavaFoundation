package com.lmr.concurrent.forkjoin;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction{

	private int start;
	private int end;
	
	public MyRecursiveAction(int start, int end){
		this.start=start;
		this.end=end;
	}
	
	@Override
	protected void compute() {
		if(end-start>2){
			int mid=(end+start)/2;
			this.invokeAll(new MyRecursiveAction(start, mid), new MyRecursiveAction(mid+1, end));
		}
		else{
			System.out.println(start+" - "+end);
		}
	}

}
