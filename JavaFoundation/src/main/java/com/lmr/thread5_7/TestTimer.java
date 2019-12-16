package com.lmr.thread5_7;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TestTimer {

	public void TestTimer1(){
	
		System.out.println("now time is "+new Date());
		
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)-5);
		Date runDate=calendar.getTime();
		
		MyTimerTask1 timerTask=new MyTimerTask1();

		Timer timer=new Timer(true);
//		timer.schedule(timerTask, 5000);
		timer.schedule(timerTask, runDate);
		
	}
	
	public void TestTimer2(){
		
		System.out.println("now time is "+new Date());
		
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)-5);
		Date runDate1=calendar.getTime();
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)-5);
		Date runDate2=calendar.getTime();
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)+2);
		Date runDate3=calendar.getTime();
		
		MyTimerTask2 timerTask1=new MyTimerTask2("TimerTask1");
		MyTimerTask2 timerTask2=new MyTimerTask2("TimerTask2");
		MyTimerTask2 timerTask3=new MyTimerTask2("TimerTask3");
		System.out.println("TimerTask1 is plan "+runDate1);
		System.out.println("TimerTask2 is plan "+runDate2);
		System.out.println("TimerTask3 is plan "+runDate3);
		
		Timer timer=new Timer();
		
		timer.schedule(timerTask1, runDate1);
		timer.schedule(timerTask2, runDate2);
		timer.schedule(timerTask3, runDate3);
		
		timerTask3.cancel();
		
	}
	
	public void TestTimer3(){
		
		System.out.println("Start "+System.currentTimeMillis());
		
		MyTimerTask3 timerTask=new MyTimerTask3();
		
		Timer timer=new Timer();
		
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
		
	}
	
	public static void main(String[] args) {
		
		TestTimer test=new TestTimer();
//		test.TestTimer1();
//		test.TestTimer2();
		test.TestTimer3();
		
	}
	
}
