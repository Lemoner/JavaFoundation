package com.lmr.thread5_7;

import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask1 extends TimerTask{

	@Override
	public void run() {
		
		System.out.println("MyTimeTask1 is run "+new Date());
		
	}

}
