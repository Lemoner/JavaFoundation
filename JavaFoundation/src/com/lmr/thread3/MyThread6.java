package com.lmr.thread3;

public class MyThread6 extends Thread{

	@Override
	synchronized public void run() {
		try {
			System.out.println("MyThread6 is start ... "+System.currentTimeMillis());
			for(int i=1;i<=5;i++){
				System.out.println("MyThread6 "+i+" "+System.currentTimeMillis());
				Thread.sleep(500);
			}
			System.out.println("MyThread6 is end ... "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	synchronized public void method(){
//		try {
			System.out.println("MyThread6 method is start ... "+System.currentTimeMillis());
			for(int i=10;i<=15;i++){
				System.out.println("MyThread6 method "+i+" "+System.currentTimeMillis());
//				Thread.sleep(0);
			}
			System.out.println("MyThread6 method is end ... "+System.currentTimeMillis());
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
	}

}
