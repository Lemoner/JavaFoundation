package com.lmr.exception;

public class TestThree {

	public void method1() throws Exception{
		
		try {
			method2();
		} catch (Exception e) {
			e.printStackTrace();
			 throw e; 
		}
		
	}
	
	private void method2() {
		try {
			method3();
		} catch (MyException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	private void method3() throws MyException {
		throw new MyException("OOOOOO");
	}

	public static void main(String[] args) {
		
		TestThree test=new TestThree();
		
		try {
			test.method1();
		} catch (MyException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("END");
	}
	
}
