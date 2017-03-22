package com.lmr.collection;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		
		int age1=o1.getAge();
		int age2=o2.getAge();
		
		if(age1<age2){
			return -1;
		}
		else if(age1>age2){
			return 1;
		}
		else{
//			return o1.getName().compareTo(o2.getName());
			//若是年龄相同时，继续比较名字；若是名字也相同的话，就继续比较id；若id也相同的话，则该条记录将不存放在该set内
			int namestate=o1.getName().compareTo(o2.getName());
			if(namestate==0){
				return Integer.compare(o1.getId(), o2.getId());
			}
			return namestate;
			
		}
	}

}
