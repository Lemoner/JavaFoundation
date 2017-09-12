package com.lmr.thread;

public class TestThread2 {

	private volatile int i=0;
//	private Object lock=new Object();
	
	public void write(int j){
//		synchronized (lock) {
//			for(int k=9;k<10000;k++){
//				i=k;
//			}
//			i=j;
//		}
		for(int k=9;k<10000;k++){
			i=k;
		}
		i=j;
	}
	
	public int read(){
//		synchronized (lock) {
//			return i;
//		}
		return i;
	}
	
	public void init(){
		Thread a=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				write(1);
			}
		});
		Thread b=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(read());
			}
		});
		a.start();
		b.start();
		
	}
	
	public static void main(String[] args) {
		
		TestThread2 t=new TestThread2();
		t.init();
		
	}
	
}
