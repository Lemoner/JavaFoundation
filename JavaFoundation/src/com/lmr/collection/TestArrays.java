package com.lmr.collection;


import java.util.Arrays;

import com.lmr.test.Student;

public class TestArrays {

	public static void main(String[] args) {
		
//		ChangeSize();
//		LookSize();
//		MoveArray();
		DeleteElement();
		
	}

	private static void DeleteElement() {
		// TODO Auto-generated method stub
		
		int a[]={0,1,2,3,4,5,6,7,8,9};
//		int b[]={0,-1,-2,-3,-4,-5,-6,-7,-8,-9};
		int b[]=new int[10];
		
		int deleteindex,size;
		
		deleteindex=3;
		size=a.length;
		
//		System.arraycopy(a, deleteindex+1, a, deleteindex, size-deleteindex-1);
		
//		System.arraycopy(b, 3, a, 7, 3);
		System.arraycopy(a, 3, b, 2, 3);
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
	}

	private static void MoveArray() {
		// TODO Auto-generated method stub
		
		int a[]={1,2,3,4,5,6,7,8,9};
		
		int index,length,temp;
		
		index=2;
		length=3;
//		temp=a[index+length];
		
		System.arraycopy(a, index, a, index+1, length);
//		a[index]=temp;
		
		System.out.println(Arrays.toString(a));
		
	}

	private static void LookSize() {
		// TODO Auto-generated method stub
		
		int[] a=new int[10];
		System.out.println(a.length);
		System.out.println(Arrays.toString(a));
		
		int[] b=new int[0];
		System.out.println(b.length);
		System.out.println(Arrays.toString(b));
		
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
