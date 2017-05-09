package com.lmr.invoke;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestArrayChangeSize {

	public static void main(String[] args) {
		
		int[] a=new int[2];
		
		a[0]=0;
		a[1]=1;
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		a=(int[]) ChangeSize(a, 5);
		
		a[2]=2;
		a[3]=3;
		a[4]=4;
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		String[] b=new String[2];
		b[0]="A";
		b[1]="B";
		
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]+" ");
		}
		System.out.println();
		
		b=(String[]) ChangeSize(b, 5);
		
		b[2]="C";
		b[3]="D";
		b[4]="E";
		
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]+" ");
		}
		System.out.println();
		
	}
	
	public static Object ChangeSize(Object obj, int newlength){
		
		Class c=obj.getClass();
		
		if(!c.isArray()){
			return null;
		}
		
		Class componenttype=c.getComponentType();//获取传进来的数组类型
		
		int oldlength=Array.getLength(obj);
		
		Object newobj=Array.newInstance(componenttype, newlength);//主要是这句话，用来实例化对应类型的数组
		
		System.arraycopy(obj, 0, newobj, 0, Math.min(oldlength, newlength));
		
		return newobj;
	}
	
}
