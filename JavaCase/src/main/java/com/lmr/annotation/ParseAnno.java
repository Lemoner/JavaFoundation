package com.lmr.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseAnno {

	public static void main(String[] args) {
		
		try {
			Class c=Class.forName("com.lmr.annotation.Child");
			
			//��ȡ���ϵ�ע��
			Boolean cflag=c.isAnnotationPresent(Describe.class);
			if(cflag){
				Describe d=(Describe) c.getAnnotation(Describe.class);
				System.out.println(d.toString()+" - - "+d.value());
			}
			
			//��ȡ�����ϵ�ע��
			Method[] ms=c.getMethods();
			for(Method m:ms){
				Boolean mflag=m.isAnnotationPresent(Describe.class);
				if(mflag){
					Describe d=m.getAnnotation(Describe.class);
					System.out.println(d.toString()+" - - "+d.value());
				}
			}
			
			for(Method m:ms){
				Annotation[] as=m.getAnnotations();
				for(Annotation a:as){
					if(a instanceof Describe){
						Describe d=(Describe) a;
						System.out.println(d.toString()+" - - "+d.value());
					}
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
