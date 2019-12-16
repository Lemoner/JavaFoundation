package com.lmr.test;

public class TestGo {

	public static void main(String[] args) {
		
		Fun1();
		
	}

	private static void Fun1() {
		
		int a=10;
		
		if(a>0)index:{
			
			first:{
			if(a>9){
				System.out.println("-");
				break index;
			}
			
		}
			
			if(a<20){
				a=30;
				break index;
			}
			
			a=40;
			
		}
		
		System.out.println(a);
	}
	
}
