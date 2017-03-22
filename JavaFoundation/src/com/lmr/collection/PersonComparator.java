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
			//����������ͬʱ�������Ƚ����֣���������Ҳ��ͬ�Ļ����ͼ����Ƚ�id����idҲ��ͬ�Ļ����������¼��������ڸ�set��
			int namestate=o1.getName().compareTo(o2.getName());
			if(namestate==0){
				return Integer.compare(o1.getId(), o2.getId());
			}
			return namestate;
			
		}
	}

}
