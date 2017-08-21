package com.lmr.test;

import java.util.Random;

public class TestRand {

	public static void main(String[] args) {
		
		Random rand=new Random();
		
		for(int i=0;i<1000;i++){
			int index;
			index=rand.nextInt(10);
			if(index==10){
				
				System.err.println(index);
				break;
			}
			System.out.println(rand.nextInt(10));
		}
		
	}
	
}
