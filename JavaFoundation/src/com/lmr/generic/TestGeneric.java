package com.lmr.generic;

import java.lang.reflect.Array;

public class TestGeneric {

	public static void main(String[] args) {

//		TestInitClass();
		
		TestInitMethod();

	}
	
	public static <T> T getMiddle(T... a){

		return a[a.length/2];
		
	}
	
	public static <T extends Comparable<T>> T getMax(T[] a){
		//对类型T设置限定，防止有的类型没有实现Comparable接口
		T max;
		if(a==null||a.length==0){
			return null;
		}
		max=a[0];
		for(int i=1;i<a.length;i++){
			if(max.compareTo(a[i])<0){
				max=a[i];
			}
		}
		return max;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> T[] getMaxMin(T[] a){
		
//		Object[] maxmin=new Object[2];//返回值后没法转换
//		T[] maxmin=new T[2];//错误的写法
		
		T[] maxmin=(T[]) Array.newInstance(a.getClass().getComponentType(), 2);//使用反射创建相应类型的数组
		
		T max;
		T min;
		
		if(a==null||a.length==0){
			return null;
		}
		max=a[0];
		min=a[0];
		for(int i=1;i<a.length;i++){
			if(max.compareTo(a[i])<0){
				max=a[i];
			}
			if(min.compareTo(a[i])>0){
				min=a[i];
			}
		}
		
		maxmin[0]=max;
		maxmin[1]=min;
		
		return (T[]) maxmin;
	}
	
	
	private static void TestInitMethod() {
		// TODO Auto-generated method stub
		
		String strmid=getMiddle("blue","red","green","yellow","black","white","orange","pink","gray");
		System.out.println(strmid);
		
		double nummid=(double) getMiddle(3.14,123,12.9,0);
		System.out.println(nummid);
		
		String[] color={"blue","red","green","yellow","black","white","orange","pink","gray"};
		System.out.println(getMax(color));
		
		String[] maxmin=getMaxMin(color);
		System.out.println(maxmin[0]+" - - "+maxmin[1]);
	}


	public static void TestInitClass(){
		
		String[] color={"blue","red","green","yellow","black","white","orange","pink","gray"};
		
		PointLink<String> headpoint = null;
		PointLink<String> prepoint = null;
		
		for(int i=0;i<color.length;i++){
			
			PointLink<String> newpoint = new PointLink<>(prepoint, color[i], null);
			
			if(prepoint==null){
				headpoint=newpoint;
			}
			else{
				prepoint.setNext(newpoint);
			}
			
			prepoint=newpoint;
			
		}
		
		PointLink<String> point = headpoint;
		while(point.getNext()!=null){
			System.out.println(point.getSelf());
			point=point.getNext();
		}
		
	}
	
}
