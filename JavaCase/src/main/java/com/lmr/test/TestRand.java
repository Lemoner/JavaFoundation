package com.lmr.test;

import java.util.Random;

public class TestRand {

	public static void main(String[] args) {

//		TestInt();
		TestDouble();
		

	}

	private static void TestDouble() {
		
		Random rand = new Random();
		int min,max;
		
		min=100;
		max=150;
		
		for(int i=0;i<100;i++){
			System.out.println(min + ((max - min) * new Random().nextDouble()));
		}
		
	}

	private static void TestInt() {

		Random rand = new Random();

		for (int i = 0; i < 1000; i++) {
			int index;
			index = rand.nextInt(10);
			if (index == 10) {

				System.err.println(index);
				break;
			}
			System.out.println(rand.nextInt(10));
		}

	}

}
