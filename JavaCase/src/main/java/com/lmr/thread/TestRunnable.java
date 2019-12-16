package com.lmr.thread;

public class TestRunnable {
	
	public static int count=100;

	public static void main(String[] args) {

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				for (int i = 0; i < 10; i++) {
					System.out.println("thread1: " + i+"   "+count--);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				for (int i = 0; i < 10; i++) {
					System.out.println("thread2: -" + i+"   "+count--);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

			}
		});
		
		thread1.start();
		thread2.start();

	}

}
