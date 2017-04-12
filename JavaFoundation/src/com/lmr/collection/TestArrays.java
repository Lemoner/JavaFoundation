package com.lmr.collection;

import java.util.Arrays;

import com.lmr.test.Student;

public class TestArrays {

	public static void main(String[] args) {
		
		ChangeSize();
		
	}

	private static void ChangeSize() {
		// TODO Auto-generated method stub
		
		int[] a=new int[100];
		
		Class c=a.getClass();
		System.out.println(c.getComponentType());
		
		Student[] sa=new Student[100];
		Class sc=sa.getClass();
		System.out.println(sc.getComponentType().getSimpleName());
		
		a=Arrays.copyOf(a, 2*a.length);//增大数组空间
		
		String[] s=new String[100];
		s=Arrays.copyOf(s, 2*s.length);
		
	}
	
}
