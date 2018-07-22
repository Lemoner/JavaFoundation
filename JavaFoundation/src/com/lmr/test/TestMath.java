package com.lmr.test;

import java.io.File;
import java.io.FileFilter;

public class TestMath {

	public static void main(String[] args) {

//		testmax();
//		testIntEqual();
//		testIntToByte();
		testDivde();
		
	}

	private static void testDivde() {
		
		int x=1;
		float y=2;
		double z=3;
		int d=3;
		
		System.out.println(x/y);
		System.out.println(x/z);
		System.out.println(x*1.0/d);
		
	}

	private static void testIntToByte() {
		
		int a=234;
		System.out.println((byte)a);
		
	}

	private static void testIntEqual() {
		
		Integer a=1;
		Integer b=2;
		Integer c=3;
		Integer d=3;
		Integer e=128;
		Integer f=128;
		Long g=3L;
		
		System.out.println(c==d);
		System.out.println(e==f);//
		System.out.println(c==(a+b));
		System.out.println(c.equals(a+b));
		System.out.println(g==(a+b));//
		System.out.println(g.equals(a+b));
		
	}

	public static void testmax() {
		int a = 10;
		int b = 20;

		int max;
		max = a > b ? a : b;
		System.out.println(max);
		
		int i=-1;
		int j=2;
		
		System.out.println(i=j);
		System.out.println(i);
		
	}

	public static void test2() {

		int x = 7;

		System.out.println(x);
		System.out.println(x << 1);
		System.out.println(x << 2);
		System.out.println(x);
		System.out.println(x >> 1);
		System.out.println(x >> 2);

	}

	public static void test1() {

		int stepsum = 5;
		int step = 1;

		while (step <= stepsum) {
			System.out.println((int) (((double) 100 / stepsum) * step + 1));
			step++;
		}

	}

}
