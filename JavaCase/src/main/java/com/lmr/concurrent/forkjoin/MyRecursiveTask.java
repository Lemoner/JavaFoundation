package com.lmr.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<String>{

	private int start;
	private int end;
	
	public MyRecursiveTask(int start, int end) {
		this.start=start;
		this.end=end;
	}

	@Override
	protected String compute() {
		
		if(end-start>2){
			int mid=(end+start)/2;
			MyRecursiveTask leftTask=new MyRecursiveTask(start, mid);
			MyRecursiveTask rightTask=new MyRecursiveTask(mid+1, end);
			leftTask.fork();
			rightTask.fork();
			return leftTask.join()+rightTask.join();
		}
		else{
			String result="";
			for(int i=start;i<=end;i++){
				result+=i;
			}
			return result;
		}
		
	}

}
