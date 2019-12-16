package com.lmr.exception;

public class TestOne {

	public static void main(String[] args) throws Exception {
		
		int[] a={9,8,7,6,5,4};
		int[] b={1,0,3,4,0,6};
		
		for(int i=0;i<a.length;i++){
			devide(i, a[i], b[i]);
		}
		
	}

	private static void devide(int i, int a, int b) throws Exception {

		try{
			double d=a/b;
			System.out.println((i+1)+" - - : "+d);
		}
		catch (ArithmeticException e){
			System.out.println("+_+");
			throw new Exception(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e);
			
		}
		
	}
	
}
