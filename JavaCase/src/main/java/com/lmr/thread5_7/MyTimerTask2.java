package com.lmr.thread5_7;

import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask2 extends TimerTask{

	private String s;
	
	public MyTimerTask2(String s){
		this.s=s;
	}
	
	@Override
	public void run() {
		System.out.println(s+" is run "+new Date());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
