package com.lmr.thread5_7;

public class MyThread1 extends Thread{

	String s;
	
	public MyThread1(String s){
		this.s=s;
	}
	
	@Override
	public void run() {
		
		while(true){
			
			System.out.println(s+" - - "+System.currentTimeMillis());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
