package com.lmr.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TestSortMap {

	public static void main(String[] args) {
		int a[] = { 425, 200, 312, 425, 222, 222, 245, 266, 285, 285, 285, 285, 312, 312, 347, 425, 459, 402, 398, 398,
				398, 335 };
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			map.put(i, a[i]);
		}

		// 这里将map.entrySet()转换成list
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		// 然后通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			// 升序排序
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}

		});

		int x,index;
		x=-1;
		index=0;
		for (Map.Entry<Integer, Integer> mapping : list) {
			System.out.println(mapping.getKey() + ":" + mapping.getValue());
			if(x!=mapping.getValue()){
				index++;
				x=mapping.getValue();
			}
			map.put(mapping.getKey(), mapping.getValue()+100*index);
		}
		System.out.println("---------------------");
		for (Map.Entry<Integer, Integer> mapping : list) {
			System.out.println(mapping.getKey() + ":" + mapping.getValue());
			map.put(mapping.getKey(), mapping.getValue()+1000);
		}
		System.out.println("---------------------");
		for(Map.Entry<Integer, Integer> sortmap:map.entrySet()){
			System.out.println(sortmap.getKey() + ":" + sortmap.getValue());
		}
		
		
		
	}
}
