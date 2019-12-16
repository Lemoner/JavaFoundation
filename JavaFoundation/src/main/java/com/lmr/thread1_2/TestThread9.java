package com.lmr.thread1_2;

public class TestThread9 {

	public static void main(String[] args) {
		
		MyThread6[] threads=new MyThread6[100];
		
		for(int i=0;i<100;i++){
			threads[i]=new MyThread6("thread"+i);
		}
		
		for(int i=0;i<100;i++){
			threads[i].start();
		}
		
	}
	
}
