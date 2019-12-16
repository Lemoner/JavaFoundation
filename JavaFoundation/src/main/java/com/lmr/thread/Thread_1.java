package com.lmr.thread;

public class Thread_1 {

	public static void main(String[] args) {
		
		MyThread mythread1=new MyThread("A");
		MyThread mythread2=new MyThread("B");
		
		mythread1.start();
		mythread2.start();
		
		
	}
	
}

class MyThread extends Thread{
	
	public int count=100;

	public String name;
	
	public MyThread(String name){
		this.name=name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<10;i++){
			System.out.println(name+" "+i+"   "+count--);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
