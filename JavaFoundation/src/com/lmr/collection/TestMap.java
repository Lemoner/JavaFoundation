package com.lmr.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
//		Map <String,String> map=new HashMap<>();
//		map.put("A", "1-23");
//		map.put("B", "2-45");
//		map.put("C", "3-67");
//		map.put("D", "4-89");
//		map.put("E", "5-10");
//		System.out.println(map.get("B"));
//		String l=map.get("B");
//		String x,y;
//		int index;
//		index=l.indexOf('-');
//		x=l.substring(0, index);
//		y=l.substring(index+1);
//		System.out.println(x);
//		System.out.println(y);
//		System.out.println(map.get("A"));
//		map.put("A",map.get("A")+"-*-*-");
//		System.out.println(map.get("A"));
//		
//		System.out.println(map.get(""));
		
		initHashMap();
	}

	private static void initHashMap() {
		// TODO Auto-generated method stub
		
		Map<Integer, String> map=new HashMap<>();
		
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		map.put(5, "E");
		
		System.out.println(map);
		
		System.out.println(map.keySet());//键集
		
		System.out.println(map.values());//值集合
		
		System.out.println(map.entrySet());//键/值对集
		
		for(Map.Entry<Integer, String> entry:map.entrySet()){
			
			System.out.println(entry.getKey()+"  - -  "+entry.getValue());
			
			if(entry.getKey()==5){
				map.entrySet().remove(entry);//可删除元素
			}
			
		}
		
		System.out.println(map);
		
		map.put(1, "F");//对同一个键重复添加，会覆盖掉原有的值
		
		System.out.println(map);
		
		map.remove(2,"B");
		
		System.out.println(map);
		
		map.replace(3, "E", "D");
		
		System.out.println(map);
	}
}
