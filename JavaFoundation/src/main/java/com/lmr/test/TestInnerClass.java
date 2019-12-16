package com.lmr.test;

import java.util.*;
public class TestInnerClass {
	
	public int x=0;
	
	public class innerClass{
		public void inFun(){
			Fun();
//			sFun();
			System.out.println(x);
		}
	}
	
	public void Fun(){
		x++;
		System.out.println("fun"+x);
	}
	
//	public static void sFun(){
//		x++;
//		System.out.println("sfun"+x);
//	}
	
	
	public static void main(String[] args){
		
		new TestInnerClass().new innerClass().inFun();
		new TestInnerClass().new innerClass().inFun();
		
		TestInnerClass t=new TestInnerClass();
		t.new innerClass().inFun();
		t.new innerClass().inFun();
		
	}

}
