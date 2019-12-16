package com.lmr.thread1_2;

public class MyService5 {
	
	private boolean isRun=true;
	
	public void runMethod(){
		while(isRun==true){
//			synchronized (this) {
//				
//			}
			System.out.println("service is running");
		}
		System.out.println("runMethod is end !");
	}
	
	public void stopMethod(){
		this.isRun=false;
	}
	
}
