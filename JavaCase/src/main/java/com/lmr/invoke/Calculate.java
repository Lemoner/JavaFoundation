package com.lmr.invoke;

public class Calculate {

	public void add(int a,int b){
		System.out.println(a+b);
	}
	
	public void subtract(int a,int b){
		System.out.println(a-b);
	}
	
	public void multiply(int a,int b){
		System.out.println(a*b);
	}
	
	public void divide(int a,int b){
		if(b!=0){
			System.out.println(a/b);
		}
	}
	
//	public int add(int a,int b){
//		return a+b;
//	}
	
	
}
