package com.lmr.concurrent_art;

class Singleton {

	private static Singleton singleton;

	public Singleton() {
	}

	public static Singleton getInstance1() {
		if (singleton == null) {
			singleton = new Singleton();
			System.out.println(Thread.currentThread().getName() + " is initalized ...");
		}
		return singleton;
	}
	
	public synchronized static Singleton getInstance2() {
		if (singleton == null) {
			singleton = new Singleton();
			System.out.println(Thread.currentThread().getName() + " is initalized ...");
		}
		return singleton;
	}
	
	public static Singleton getInstance3() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if(singleton==null){
					singleton = new Singleton();
					System.out.println(Thread.currentThread().getName() + " is initalized ...");
				}
			}
		}
		return singleton;
	}
	
	public static Singleton getInstance4() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if(singleton==null){
					singleton = new Singleton();
					System.out.println(Thread.currentThread().getName() + " is initalized ...");
				}
			}
		}
		return singleton;
	}
	
	//����singleton����Ϊvolatile����֤�ڴ�ɼ���
	public static Singleton getInstance5() {
		return singleton;
	}

}

//ʹ�����ʼ�����м���
class SingletonFactoy{
	
	private static class SingletonHandler{
		public static Singleton singleton=new Singleton();
	}

	public static Singleton getInstance() {
		return SingletonHandler.singleton;
	}
	
}

public class TestDCL {

	public static void main(String[] args) {
		for (int i = 1; i < 1000; i++) {
			Thread t1 = new Thread(new ThreadSingleton());
			t1.setName("thread" + i);
			t1.start();
		}
	}

	public static class ThreadSingleton implements Runnable {
		@Override
		public void run() {
//			Singleton.getInstance1();
//			Singleton.getInstance2();
			Singleton.getInstance3();
//			SingletonFactoy.getInstance();
		}
	}

}
