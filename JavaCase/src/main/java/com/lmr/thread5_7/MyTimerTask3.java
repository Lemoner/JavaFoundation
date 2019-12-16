package com.lmr.thread5_7;

import java.util.TimerTask;

public class MyTimerTask3 extends TimerTask{
	
	@Override
	public void run() {
		
		System.out.println("MyTimerTask3 is run "+System.currentTimeMillis());
		
		for(int i=1;i<10;i++){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i+" - - "+System.currentTimeMillis());
		}
		
	}

}
