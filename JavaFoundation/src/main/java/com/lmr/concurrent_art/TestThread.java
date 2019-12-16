package com.lmr.concurrent_art;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class TestThread {

	public static void main(String[] args) {
		
		TestThread test=new TestThread();
		
		test.LookThreadOfIsRun();
		
	}

	private void LookThreadOfIsRun() {
		
		ThreadMXBean mxBean=ManagementFactory.getThreadMXBean();
		
		for(ThreadInfo info:mxBean.dumpAllThreads(false, false)){
			System.out.println(info.toString());
		}
		
	}
	
}
