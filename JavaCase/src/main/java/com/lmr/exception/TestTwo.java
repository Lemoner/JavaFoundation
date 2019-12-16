package com.lmr.exception;

public class TestTwo {

	public static void main(String[] args) {
		
		InitException initException=new InitException();
		
		try {
			initException.init("A");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
