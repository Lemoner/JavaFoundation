package com.lmr.concurrent_art;

public class Test {

	public static void main(String[] args) {
		
		Test test=new Test();
		
		try {
			test.TestOne();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void TestOne() throws InterruptedException {
		
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				int count=0;
				for(int i=0;i<100;i++){
					count+=i;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(count);
			}
		});
		thread.start();
		System.out.println(thread.getId()+" - "+Thread.currentThread().getId());
		
		int sum=99999;
		for(int i=0;i<1000000;i++){
			sum-=i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(sum);
		
//		thread.join();
		
		System.out.println("END");
	}
	
}
