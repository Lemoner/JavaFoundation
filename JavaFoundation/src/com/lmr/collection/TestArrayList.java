package com.lmr.collection;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.w3c.dom.ls.LSException;

public class TestArrayList {

	public static void main(String[] args) {
		
//		SimpleUse();
//		TestAddIndex();
//		TestAdd();
//		TestAddAndRemove();
//		TestSortByComparator();
//		TestDynamicAdd();
		TestIterator();

		
	}
	
	private static void TestIterator() {
		
//		List<Integer> list=new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		
//		Iterator<Integer> iterator=list.iterator();
//		while (iterator.hasNext()) {
////			iterator.next();
//			iterator.remove();
//			System.out.println(list.size());
//		}
		
		
		CopyOnWriteArrayList<Integer> arrayList=new CopyOnWriteArrayList<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		
		Iterator<Integer> iterator=arrayList.iterator();
		while (iterator.hasNext()) {
//			iterator.next();
			int x=iterator.next();
			System.out.println(x+" "+arrayList.size());
			if(x==2){
				arrayList.remove(new Integer(3));
			}
		}
		System.out.println(arrayList.toString());
		
	}

	private static void TestDynamicAdd() {
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list.toString());
		
//		list.add(2, 22);
//		System.out.println(list.toString());
		
		for(int i=0;i<list.size();i++){
			if(list.get(i)%2==0){
				list.add(i+1,999);
				i++;
			}
		}
		System.out.println(list.toString());
		
	}

	private static void TestSortByComparator() {
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(4);
		list.add(2);
		
		System.out.println(list);
		
		list.add(2,11);
		System.out.println(list);
		
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				if(o1<o2){
					return 1;
				}
				else{
					return -1;
				}
				
//				return o1.compareTo(o2);
			}

		});
		
		System.out.println(list);
		
	}

	private static void TestAddAndRemove(){
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list.toString());
		System.out.println(list.remove(5));
		System.out.println(list.toString());
		
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
