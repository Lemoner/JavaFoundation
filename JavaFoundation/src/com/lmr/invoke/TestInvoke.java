package com.lmr.invoke;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestInvoke {

	public static void main(String[] args) {
		
//		InvokeOne();
		
		InvokeTwo();
		
	}
	
	private static void InvokeTwo() {
		// TODO Auto-generated method stub
		
		try {
			
			Class studentclass=Class.forName("com.lmr.invoke.Student");
			
			Object stuobj=studentclass.newInstance();
			
			Method setStuName=studentclass.getMethod("setName", String.class);
			setStuName.invoke(stuobj, "Jack");
			
//			PropertyDescriptor pd=new PropertyDescriptor("name", studentclass);//通过属性名来获取对应的存储器，从而获取其get，set方法
//			Method setStuName=pd.getWriteMethod();
			
			Method toStuString=studentclass.getMethod("toString");
			System.out.println(toStuString.invoke(stuobj));
			
			Field name=studentclass.getDeclaredField("name");
			name.setAccessible(true);//解除封装
			name.set(stuobj, "Jane");
			
			System.out.println(toStuString.invoke(stuobj));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void InvokeOne(){
		
		try {
			Class calculateclass=Class.forName("com.lmr.invoke.Calculate");
			
			Class[] paramtype={int.class, int.class};
			Method m=calculateclass.getMethod("add", paramtype);
			
//			Method m=calculateclass.getMethod("add", int.class, int.class);
			
			m.invoke(calculateclass.newInstance(), 1, 2);//method.invoke(对象，参数列表);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
