package com.lmr.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestLinkedList {

	public static void main(String[] args) {
		
		List<String> a=new LinkedList<>();
		a.add("Red");
		a.add("Blue");
		a.add("White");
		
		List<String> b=new LinkedList<>();
		b.add("Apple");
		b.add("Banana");
		b.add("Lemon");
		b.add("Watermelon");
		b.add("Cherry");
		
		ListIterator<String> aIter=a.listIterator();
		Iterator<String> bIter=b.iterator();
		
		while (aIter.hasNext()) {
			String next;
			String pre = null;
			if(aIter.hasPrevious()){//next()和previous()是将迭代器移动，越过下一个元素，并返回刚才越过的元素的引用
				pre=(String) aIter.previous();
				aIter.next();//将迭代器指标往后移动一次
				next=(String) aIter.next();
			}
			else{
				next=(String) aIter.next();
			}
			System.out.println(pre + " - - "+next);
			
		}
		
		while(bIter.hasNext()){//向a中添加b中的元素（每隔一个a中的元素添加一个b中的元素，当a中原有的元素遍历完后，b中剩下的元素添加到a的末尾）
			if(aIter.hasNext()){
				aIter.next();
			}
			aIter.add(bIter.next());
		}
		
		System.out.println(a);
		
		bIter=b.iterator();//删除b中的元素（每隔一个元素删除一个）
		while(bIter.hasNext()){
			bIter.next();
			if(bIter.hasNext()){
				bIter.next();
				bIter.remove();
			}
		}
		
		System.out.println(b);
		
		a.removeAll(b);//从a中去除b
		
		System.out.println(a);
		
	}
}
