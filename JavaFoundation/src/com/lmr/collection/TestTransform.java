package com.lmr.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestTransform {

	public static void main(String[] args) {
		
//		initJiaoBingCha();
		
//		initArrayToCollection();
		
		initCollectionToArray();
		
	}

	private static void initCollectionToArray() {
		// TODO Auto-generated method stub
		
		List<String> l=new ArrayList<>();
		
		for(int i=0;i<10;i++){
			l.add(String.valueOf((char)('A'+i)));
		}
		
//		String[] a=new String[l.size()];
//		l.toArray(a);//������ռ�С��List�ĳ��ȣ����޷�ת��
		
		String[] a;
		a=l.toArray(new String[0]);//ͨ�����������ص������Զ�����һ��ָ����С������ռ�
		
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
		
//		List<String> l=new ArrayList<>();
//		l=Arrays.asList(a);
		
//		Set<String> s=new HashSet<>();//�����������ظ�Ԫ�أ�Set���Զ����Ե��ظ���Ԫ��
//		s.addAll(Arrays.asList(a));
		
		Set<String> s=new HashSet<>(Arrays.asList(a));
		
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
		
		System.out.println(aSet);
		System.out.println(bSet);
		
		aSet.retainAll(bSet);//A=A��B
		System.out.println(aSet);
		
		aSet.addAll(bSet);//A=A��B
		System.out.println(aSet);
		
		aSet.removeAll(bSet);//A=A-B
		System.out.println(aSet);
		
	}
	
}
