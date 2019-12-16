package com.lmr.thread3;

public class TestThread4 {

	public static void main(String[] args) {
		
		MyThread6 thread6=new MyThread6();
		MyThread7 thread7=new MyThread7(thread6);
		thread7.start();
		MyThread8 thread8=new MyThread8(thread6);
		thread8.start();
		
	}
	
}
