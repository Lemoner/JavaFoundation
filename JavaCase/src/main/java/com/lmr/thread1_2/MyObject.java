package com.lmr.thread1_2;

public class MyObject {
	
	private int num=0;
	
	synchronized public void add(String u){
		try {
			if("a".equals(u)){
				num=100;
				System.out.println("a set over !");
				Thread.sleep(1000);
			}
			else{
				num=200;
				System.out.println("b set over !");
			}
			System.out.println(u+" - - "+num);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	synchronized public void adda(String u){
		try {
			num=100;
			System.out.println("adda a set over ! "+System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println(u+" - - "+num+" - - "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	synchronized public void addb(String u){
		num=200;
		System.out.println("addb b set over ! "+System.currentTimeMillis());
		System.out.println(u+" - - "+num+" - - "+System.currentTimeMillis());
	}
	
	public void sum(String u){
		System.out.println("sum "+u+" over ! "+System.currentTimeMillis());
	}
}
