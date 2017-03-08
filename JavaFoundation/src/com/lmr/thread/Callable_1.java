package com.lmr.thread;

import java.util.concurrent.Callable;

public class Callable_1 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("callable is runing");
		
		int sum=0;
		for(int i=0;i<10;i++){
			
			Thread.sleep(1000);
			sum+=i;
			System.out.println(i+" - "+sum);//每隔1秒打印数据
			
		}
		
		return sum;
	}

}
