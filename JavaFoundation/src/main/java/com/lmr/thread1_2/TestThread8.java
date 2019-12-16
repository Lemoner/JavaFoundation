package com.lmr.thread1_2;

public class TestThread8 {

	public static void main(String[] args){
		
		MyService4 service=new MyService4();
		
		MyThread5 thread1=new MyThread5(service, "a");
		thread1.start();
		
		MyThread5 thread2=new MyThread5(service, "b");
		thread2.start();
		
	}
	
}
