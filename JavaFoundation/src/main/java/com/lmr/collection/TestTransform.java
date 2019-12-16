package com.lmr.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestTransform {

	public static void main(String[] args) {
		
		initJiaoBingCha();
		
//		initArrayToCollection();
		
//		initCollectionToArray();
		
	}

	private static void initCollectionToArray() {
		// TODO Auto-generated method stub
		
		List<String> l=new ArrayList<>();
		
		for(int i=0;i<10;i++){
			l.add(String.valueOf((char)('A'+i)));
		}
		
//		String[] a=new String[l.size()];
//		l.toArray(a);//若数组空间小于List的长度，则无法转换
		
		String[] a;
		a=l.toArray(new String[0]);//通过方法所返回的数组自动构造一个指定大小的数组空间
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"  ");
		}
		
	}

	private static void initArrayToCollection() {
		// TODO Auto-generated method stub
		
		String[] a=new String[10];
		
		for(int i=0;i<10;i++){
			a[i]=String.valueOf((char)('A'+i));
		}
		
		List<String> l=new ArrayList<>();
		l=Arrays.asList(a);
		
		System.out.println(l);
		
		Set<String> s=new HashSet<>();//若数组中有重复元素，Set会自动忽略掉重复的元素
		s.addAll(Arrays.asList(a));
		
		System.out.println(s);
		
		
	}

	private static void initJiaoBingCha() {
		// TODO Auto-generated method stub
		
		Set<String> aSet=new HashSet<>();
		Set<String> bSet=new HashSet<>();
		
		for(int i=0;i<10;i++){
			aSet.add(String.valueOf((char)('A'+i)));
		}
		
		for(int i=5;i<15;i++){
			bSet.add(String.valueOf((char)('A'+i)));
		}
		
		System.out.println("A "+aSet);
		System.out.println("B "+bSet);
		
		aSet.retainAll(bSet);//A=A∩B
		System.out.println("A=A∩B "+aSet);
		
		aSet.addAll(bSet);//A=A∪B
		System.out.println("A=A∪B "+aSet);
		
		aSet.removeAll(bSet);//A=A-B
		System.out.println("A=A-B "+aSet);
		
	}
	
}
