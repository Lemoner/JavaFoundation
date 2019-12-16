package com.lmr.thread;

import java.util.concurrent.Callable;

public class Callable_2 implements Callable<Integer>{

	String name;
	int end;
	
	public Callable_2(String name, int end){
		this.name=name;
		this.end=end;
	}
	
	@Override
	public Integer call(){
		// TODO Auto-generated method stub
		
		System.out.println(name+" "+end+" is runing");
		
		try {
			for(int i=0;i<100;i++){
				System.out.println(name+" - - "+i);
				if(i==end){
					int k=10/0;
					System.out.println(k);
				}
				Thread.sleep(500);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(name+" "+end+" is end ----------");
		
		return 1;
	}

}
