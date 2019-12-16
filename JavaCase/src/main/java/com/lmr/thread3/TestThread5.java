package com.lmr.thread3;

public class TestThread5 {

	public static void main(String[] args) {
		
		ThreadLocal<String> local=new ThreadLocal<String>();
		
		if(local.get()==null){
			System.out.println("------------");
			local.set("123");
		}
		System.out.println(local.get());
		System.out.println(local.get());
		
	}
	
}
