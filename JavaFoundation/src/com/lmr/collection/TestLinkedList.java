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
		
		while(bIter.hasNext()){//��a�����b�е�Ԫ�أ�ÿ��һ��a�е�Ԫ�����һ��b�е�Ԫ�أ���a��ԭ�е�Ԫ�ر������b��ʣ�µ�Ԫ����ӵ�a��ĩβ��
			if(aIter.hasNext()){
				aIter.next();
			}
			aIter.add(bIter.next());
		}
		
		System.out.println(a);
		
		bIter=b.iterator();//ɾ��b�е�Ԫ�أ�ÿ��һ��Ԫ��ɾ��һ����
		while(bIter.hasNext()){
			bIter.next();
			if(bIter.hasNext()){
				bIter.next();
				bIter.remove();
			}
		}
		
		System.out.println(b);
		
		a.removeAll(b);//��a��ȥ��b
		
		System.out.println(a);
		
	}
}
