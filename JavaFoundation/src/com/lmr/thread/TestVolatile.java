package com.lmr.thread;

public class TestVolatile {
	
	int a=0;
	volatile boolean flag=false;
	
	public static void main(String[] args) {
		
		TestVolatile test=new TestVolatile();
		test.TestOne();
		
	}

	public void TestOne() {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				a=1;
				for(int i=0;i<1000000;i++){
					
				}
				flag=true;
				System.out.println("END");
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(flag){
					System.out.println("+-+");
				}
				else{
					System.out.println("---");
				}
			}
		}).start();
		
	}
	
}
