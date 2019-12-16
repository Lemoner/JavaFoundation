package com.lmr.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestListOne {

	public static void main(String[] args) {
		
		List<String> list=new ArrayList<>();
		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");
		list.add("I");
		list.add("J");
		list.add("K");
		
		System.out.println(list);
		
//		int num=0;
//		for(int i=0;i<list.size();i++){
//			System.out.println(i+" - - "+list.size()+" - - "+list+" - - "+num);
//			if(i%2==0){
//				list.remove(i);
//				num++;
//			}
////			i=i-num+1;
//		}
		
//		int index=0;
//		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//			String string = (String) iterator.next();
//			if(index%2==0){
//				iterator.remove();
//			}
//			index++;
//			
//		}
		
		System.out.println(list);
		
		list.remove(1);
		
	}
	
}
