package com.lmr.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map <String,String> map=new HashMap<>();
		map.put("A", "1-23");
		map.put("B", "2-45");
		map.put("C", "3-67");
		map.put("D", "4-89");
		map.put("E", "5-10");
		System.out.println(map.get("B"));
		String l=map.get("B");
		String x,y;
		int index;
		index=l.indexOf('-');
		x=l.substring(0, index);
		y=l.substring(index+1);
		System.out.println(x);
		System.out.println(y);
		System.out.println(map.get("A"));
		map.put("A",map.get("A")+"-*-*-");
		System.out.println(map.get("A"));
		
		System.out.println(map.get(""));
	}
}
