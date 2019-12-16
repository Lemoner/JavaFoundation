package com.lmr.exception;

public class Exception1 {

	public void ThrowsException(String s){
		
		if("A".equals(s)){
			int i=10/0;
			System.out.println(i);
		}
		
	}
	
}
