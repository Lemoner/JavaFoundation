package com.lmr.thread;

//Ïß³Ì¼ÓËø

public class TestSynchronized {

	public static void main(String[] args) throws InterruptedException {
		
		Object a = new Object();   
        Object b = new Object();   
        Object c = new Object();   
		
		Thread thread1=new Thread(new MyThreadPrint("A",c,a));
		Thread thread2=new Thread(new MyThreadPrint("B",a,b));
		Thread thread3=new Thread(new MyThreadPrint("C",b,c));
		
		thread1.start();
//		Thread.sleep(100);
		thread2.start();
//		Thread.sleep(100);
		thread3.start();
//		Thread.sleep(100);
		
	}
	
}

class MyThreadPrint implements Runnable{

	private String name;
	private Object prev;
	private Object self;
	
	public MyThreadPrint(String name, Object prev, Object self){
		
		this.name=name;
		this.prev=prev;
		this.self=self;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int count=5;
		
		while(count>0){
			
			synchronized (prev) {
				synchronized (self) {
				
					System.out.println("   "+count+"  "+name);
					count--;
					self.notify();
					
				}
				try {
					prev.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
}
