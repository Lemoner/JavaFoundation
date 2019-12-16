package com.lmr.thread1_2;

public class MyService3 {
	
	synchronized public static void service1(String u){
		try {
			System.out.println(u+" - service1 - begin - "+System.currentTimeMillis());
			Thread.sleep(500);
			System.out.println(u+" - service1 - end - "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized public static void service2(String u) {
		try {
			System.out.println(u+" - service2 - begin - "+System.currentTimeMillis());
			Thread.sleep(500);
			System.out.println(u+" - service2 - end - "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void service3(String u) {
		synchronized(MyService3.class){
			try {
				System.out.println(u+" - service3 - begin - "+System.currentTimeMillis());
				Thread.sleep(500);
				System.out.println(u+" - service3 - end - "+System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
