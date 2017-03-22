package com.lmr.collection;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

	public static void main(String[] args) {
		
		List<String> stringlists=new ArrayList<String>();
		
		stringlists.add("bf");
		stringlists.add("jty");
		stringlists.add("df");
		stringlists.add("jj");
		stringlists.add("ad");
		stringlists.add("ce");
		
		System.out.println(stringlists.size());
		for(String s:stringlists){
			System.out.println(s);
		}
		
//		System.out.println(stringlists.get(4));
//		System.out.println(stringlists.get(stringlists.size()-1));
		
		stringlists.remove(3);
		
		System.out.println(stringlists.size());
		for(String s:stringlists){
			System.out.println(s);
		}
		
		stringlists.clear();
		System.out.println(stringlists.size());

	}
	
}
