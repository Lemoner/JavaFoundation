package com.lmr.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

	public static void main(String[] args) {

		TestRegex test = new TestRegex();

//		test.TestOne();
//		test.TestTwo();
//		test.TestThree();
//		test.TestFour();
		test.TestFive();

	}

	private void TestFive() {
		
		String str="asdfa: 21312";
		String regex="([\\d+]*?)";
		
		String [] dataStr = str.split(regex); 
	    for(String s:dataStr){ 
	      System.out.println(s);
	      System.out.println("+-+");
	    } 
		
	}

	private void TestFour() {
		
		String str="[processID:1	processName:setup	processParam:null	processStatus:	processExec:] [processID:2	processName:init_ardupilot	processParam:[null]	processStatus:	processExec:] [processID:3	processName:init	processParam:[null]	processStatus:	processExec:] [processID:4	processName:init	processParam:null	processStatus:	processExec:] [processID:5	processName:init_rc_in	processParam:null	processStatus:	processExec:]";
//		String regex="\\]([\\s|\\S]*?)\\[";
		String regex="\\]([\\s]*?)\\[";
		
		String [] dataStr = str.split(regex); 
	    for(String s:dataStr){ 
	      System.out.println(s);
	      System.out.println("+-+");
	    } 
	    
	}

	private void TestThree() {
		
		String str="wind_speed:16	takeoff_alt:460	battery_remaining:32%	time:209";
		String regex="\\d+";
		
		Pattern pat = Pattern.compile(regex);
		Matcher mat = pat.matcher(str);
		
		while (mat.find()) {
			System.out.println(mat.group(0).trim());
		}
		
		
	}

	private void TestTwo() {
		
//		String str="processID:6	processName:open	processParam:Floor=1,State=0,callUp[1]!=false,callDown[1]!=false,callCar[1]!=false	processStatus:t6=2005.87	processExec:true";
		String str="processID:72	processName:set_auto_armed	processParam:_task_time_allowed=0,control_mode=4,I=18,time_available=0,packet.command=22,msg.msgid=76,_num_tasks=19,dt=0,interval_ticks=0,ap.land_complete=1,takeoff_alt_cm=---,current_loc.alt=---,gcs[I].initialised=True,has_armed=True,mode_has_user_takeoff=True	processStatus:	processExec:";
		String regex="processParam:([\\s|\\S]*?)processStatus:";
		
		Pattern pat = Pattern.compile(regex);
		Matcher mat = pat.matcher(str);
		
		while (mat.find()) {
			System.out.println(mat.group(1).trim());
		}
		
	}

	private void TestOne() {
		
		String str="32a442";
		String regex="\\d+";
		
		System.out.println(str.matches(regex));
		
	}

}
