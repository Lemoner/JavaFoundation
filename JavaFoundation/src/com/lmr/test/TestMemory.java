package com.lmr.test;

import java.util.ArrayList;
import java.util.List;

public class TestMemory {
	
	static class OOMObject {}

	public static void main(String[] args) {
		
		TestFun1();
		
	}

	private static void TestFun1() {
//		TestFun1();
//		for(;;){
//			Object[] objects=new Object[1024*1024];
//		}
		List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
	}
	
}
