package com.lmr.test;

import java.util.Date;

public class TestTime {

	public static void main(String[] args) {
		
		long time1;
		long time2;
		
		time1=System.currentTimeMillis();//获取当前的毫秒
		
		for(int i=0;i<100;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		time2=System.currentTimeMillis();
		
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time2-time1);
		
	}
	
}
