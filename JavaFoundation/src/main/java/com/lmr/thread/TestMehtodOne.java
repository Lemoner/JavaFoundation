package com.lmr.thread;

public class TestMehtodOne {

	public static void main(String[] args) {
		
	}
	
	public static void Method(){
		
		for(int i=0;i<100;i++){
			System.out.println(i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
