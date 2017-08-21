package com.lmr.collection;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.w3c.dom.ls.LSException;

public class TestArrayList {

	public static void main(String[] args) {
		
//		SimpleUse();
//		TestAddIndex();
		TestAdd();
		
	}

	private static void TestAdd() {
		
		List<String> list=new ArrayList<>();
		list.add("acc");
		list.add("high");
		list.add("thread");
		System.out.println(list.size());
		System.out.println(list);
		list.add("high");
		System.out.println(list.size());
		System.out.println(list);
		
	}

	private static void TestAddIndex() {
		
		List<String> sList=new ArrayList<>();
		sList.add(1, "one");//会抛异常，下标越界。执行该方法时会先检测 index > size || index < 0 
		System.out.println(sList.size());
		
	}

	private static void SimpleUse() {
			
		List<String> stringlists=new ArrayList<String>();
		
		stringlists.add("bf");
		stringlists.add("jty");
		stringlists.add("df");
		stringlists.add("jj");
		stringlists.add("ad");
		stringlists.add("ce");
		
		System.out.println(stringlists.size());
		
		stringlists.add(2, "one");
		
		System.out.println(stringlists);
		
//		String str=stringlists.toString();
//		System.out.println(str);
//		System.out.println(str.replaceAll("\\[|]", ""));
//		
//		System.out.println(stringlists.size());
//		for(String s:stringlists){
//			System.out.println(s);
//		}
//		
////		System.out.println(stringlists.get(4));
////		System.out.println(stringlists.get(stringlists.size()-1));
//		
//		stringlists.remove(3);
//		
//		System.out.println(stringlists.size());
//		for(String s:stringlists){
//			System.out.println(s);
//		}
//		
//		stringlists.clear();
//		System.out.println(stringlists.size());
		
	}
	
}
