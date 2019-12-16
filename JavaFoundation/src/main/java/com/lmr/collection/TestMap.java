package com.lmr.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.plaf.synth.SynthSpinnerUI;

import java.util.Set;

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
		
//		initHashMap();
		
//		initTreeMap();
		
//		AddRepeatData();
		
//		initObjectData();
		
//		testNullData();
		
//		initHashMapIterator();
		
		TestSort();
		
	}

	private static void TestSort() {
		
		HashMap<String, Integer> hashMap=new HashMap<>();
		
		hashMap.put("a", 1);
		hashMap.put("b", 2);
		hashMap.put("ac", 3);
		hashMap.put("c", 4);
		hashMap.put("de", 5);
		hashMap.put("cc", 6);
		
		System.out.println(hashMap.keySet().toString());
		
		hashMap.put("ad", 7);
		hashMap.put("dc", 8);
		hashMap.put("bb", 9);
		
		System.out.println(hashMap.keySet().toString());
		
		TreeMap<String, Integer> treeMap=new TreeMap<>();
		
		treeMap.put("a", 1);
		treeMap.put("b", 2);
		treeMap.put("ac", 3);
		treeMap.put("c", 4);
		treeMap.put("de", 5);
		treeMap.put("cc", 6);
		
		System.out.println(treeMap.keySet().toString());
		
		treeMap.put("ad", 7);
		treeMap.put("dc", 8);
		treeMap.put("bb", 9);
		
		System.out.println(treeMap.keySet().toString());
		
	}

	private static void initHashMapIterator() {
		
		ConcurrentHashMap<String, String> map=new ConcurrentHashMap<>();
		
		map.put("1", "A");
		map.put("2", "B");
		map.put("3", "C");
		map.put("4", "D");
		map.put("5", "E");
		
		Enumeration<String> iterator=map.keys();
		
		while (iterator.hasMoreElements()) {
			String str = (String) iterator.nextElement();
			
			System.out.println(str+" "+map.size());
			if(str.equals("2")){
				map.remove("3");
				map.remove("4");
				System.out.println(map.size());
			}
		}
		
	}

	private static void testNullData() {
		
		HashMap<String, String> map=new HashMap<>();
		
		map.put(null, "A");
		map.put("k1", null);
		map.put("k2", null);
		map.put("k3", "V");
		
		System.out.println(map.size());
		System.out.println(map.get(null));
		System.out.println(map.get("K1"));
		System.out.println(map.get("k1")==map.get("k2"));
		System.out.println(map.get("k1")==null);
		System.out.println(map.getOrDefault("k1", "D"));
		
	}

	private static void initObjectData() {
		// TODO Auto-generated method stub
		
		HashMap<String, String> hashMap=new HashMap<>();
		
		hashMap.put("A", "A");
		hashMap.put("B", "B");
		hashMap.put("C", "C");
		
		Set<String> set1=hashMap.keySet();
		Set<String> set2=hashMap.keySet();
		
		Set<String> set3=new HashSet<>();
		
		set1.remove("B");
		set3.add("X");
		
		System.out.println(set1.toString());
		System.out.println(set2.toString());
		System.out.println(set3.toString());
		
		System.out.println("hashMap "+hashMap.size()+" "+hashMap);
		
	}

	private static void AddRepeatData() {
		// TODO Auto-generated method stub
		
//		HashMap<Integer, String> hashMap=new HashMap<>();
//		
//		hashMap.put(1, "A");
//		hashMap.put(2, "B");
//		hashMap.put(3, "C");
//		hashMap.put(1, "AAA");
//		hashMap.put(3, "CC");
		
		HashMap<String, String> hashMap=new HashMap<>();
		
		hashMap.put(new String("A"), "A");
		hashMap.put(new String("B"), "B");
		hashMap.put(new String("C"), "C");
		hashMap.put(new String("A"), "AAA");
		hashMap.put(new String("B"), "CC");
		
		System.out.println("hashMap "+hashMap.size()+" "+hashMap);
		
		Hashtable<Integer, String> hashtable=new Hashtable<>();
		
		hashtable.put(1, "A");
		hashtable.put(2, "B");
		hashtable.put(3, "C");
		hashtable.put(1, "AAA");
		hashtable.put(3, "CC");
		
		System.out.println("hashtable "+hashtable.size()+" "+hashtable);
		
		IdentityHashMap<String, String> identityHashMap=new IdentityHashMap<>();
		
		identityHashMap.put(new String("A"), "A");
		identityHashMap.put(new String("B"), "B");
		identityHashMap.put(new String("C"), "C");
		identityHashMap.put(new String("A"), "AAA");
		identityHashMap.put(new String("B"), "CC");
		
		System.out.println("identityHashMap "+identityHashMap.size()+" "+identityHashMap);
		
	}

	private static void initTreeMap() {
		// TODO Auto-generated method stub
		
//		SortedMap<Integer, Person> map=new TreeMap<>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				//降序排列
//				return o2-o1;
//			}
//		});
		
		SortedMap<Integer, Person> map=new TreeMap<>();
		
		map.put(1, new Person(1, "A", 15));
		map.put(3, new Person(3, "B", 11));
		map.put(5, new Person(5, "C", 13));
		map.put(2, new Person(2, "D", 19));
		map.put(4, new Person(4, "E", 10));
		
//		map.put("v", new Person(1, "A", 15));
//		map.put("c", new Person(3, "B", 11));
//		map.put("s", new Person(5, "C", 13));
//		map.put("a", new Person(2, "D", 19));
//		map.put("b", new Person(4, "E", 10));
		
		// 这里将map.entrySet()转换成list
		List<Map.Entry<Integer, Person>> list = new ArrayList<Map.Entry<Integer, Person>>(map.entrySet());
		// 然后通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<Integer, Person>>() {
			// 升序排序
			public int compare(Entry<Integer, Person> o1, Entry<Integer, Person> o2) {
				return o1.getValue().getAge()-o2.getValue().getAge();
			}

		});
		
		for(Map.Entry<Integer, Person> m:list){
			System.out.println(m.getKey()+" - - "+m.getValue());
		}
		System.out.println("----------------------");
		for(Integer key:map.keySet()){
			System.out.println(key+" - - "+map.get(key));
		}
		for(Person p:map.values()){
			System.out.println(p);
		}
		System.out.println(map);
		
	}

	private static void initHashMap() {
		// TODO Auto-generated method stub
		
		Map<Integer, String> map=new HashMap<>();
		
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		map.put(5, "E");
		map.put(6, "F");
		
		System.out.println(map);
		
		System.out.println(map.keySet());//键集
		
		System.out.println(map.values());//值集合
		
		System.out.println(map.entrySet());//键/值对集
		
		for(Map.Entry<Integer, String> entry:map.entrySet()){
			
			System.out.println(entry.getKey()+"  - -  "+entry.getValue());
			
			if(entry.getKey()==6){
				map.entrySet().remove(entry);//可删除元素
			}
			
		}
		
		System.out.println(map);
		
		map.put(1, "a");//对同一个键重复添加，会覆盖掉原有的值
		
		System.out.println(map);
		
		map.remove(2, "B");
		
		System.out.println(map);
		
		map.replace(3, "D");
		
		System.out.println(map);
	}
}
