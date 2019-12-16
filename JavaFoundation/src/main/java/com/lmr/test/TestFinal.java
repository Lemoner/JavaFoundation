package com.lmr.test;

import java.util.ArrayList;
import java.util.List;

public class TestFinal {
	
	final int count=10;
	final List<Integer> countlist=new ArrayList<>();

	public static void main(String[] args) {
		
		TestFinal test=new TestFinal();
		
		test.countlist.add(2);
		
	}
	
}
