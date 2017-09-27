package com.lmr.test;

public class TestMath {

	public static void main(String[] args) {

		test2();

	}

	public static void testmax() {
		int a = 10;
		int b = 20;

		int max;
		max = a > b ? a : b;
		System.out.println(max);
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
