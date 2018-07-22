package com.lmr.exception;

public class TestFour {

	public static void Fun(){
		try {
			throw new RuntimeException();
		} finally {
			System.out.println("Fun");
		}
	}
	
	public static void Block(){
		try {
			Fun();
		} catch (Exception e) {
			System.out.println("Block");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			Block();
		} catch (Exception e) {
			System.out.println("Main");
		}
		
	}
	
}
