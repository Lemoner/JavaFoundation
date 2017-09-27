package com.lmr.invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.concurrent.Phaser;

public class TestClass {

	public static void main(String[] args) {
		
//		try {
//			initClass();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		initClassInfo();
		
	}

	private static void initClassInfo() {
		// TODO Auto-generated method stub
		
//		Class c=Student.class;
//		Class c=Math.class;
//		Class c=List.class;
		Class c=Phaser.class;
		
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
//		System.out.println(c.getComponentType());
		
//		Field[] fields=c.getFields();//获取public类型的成员变量
		Field[] fields=c.getDeclaredFields();//成员变量信息,获取全部
		
		System.out.println("----------成员变量----------");
		for(Field f:fields){
			
			int mod=f.getModifiers();
			String modtype=Modifier.toString(mod);//方法的属性
			
			System.out.println(modtype+" "+f.getType().getSimpleName()+" "+f.getName());
			
		}
		
		Constructor[] constructors=c.getDeclaredConstructors();//获取构造函数信息
		System.out.println("----------构造函数----------");
		for(Constructor con:constructors){
			
			String name=con.getName();//方法名
			Class[] paramterType=con.getParameterTypes();//方法中参数类型
			
			int mod=con.getModifiers();
			String modtype=Modifier.toString(mod);//方法的属性
			
			System.out.print(modtype+" "+name+" (");
			for(Class p:paramterType){
				System.out.print(p.getSimpleName()+" ");
			}
			System.out.println(")");
			
		}
		
		Method[] methods=c.getMethods();//获取函数方法信息
		System.out.println("-----------方法-----------");
		for(Method m:methods){
			
			String name=m.getName();//方法名
			Class returnType=m.getReturnType();//方法返回类型
			Class[] paramterType=m.getParameterTypes();//方法中参数类型
			
			int mod=m.getModifiers();
			String modtype=Modifier.toString(mod);//方法的属性
			
			System.out.print(modtype+" "+returnType.getSimpleName()+" "+name+" (");
			for(Class p:paramterType){
				System.out.print(p.getSimpleName()+" ");
			}
			System.out.println(")");
		}
		
	}

	private static void initClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		
		//三种实例方式
		Class s1=Class.forName("com.lmr.invoke.Student");
		
		Class s2=Student.class;
		
		Student s=new Student(1,"1",1);
		Class s3=s.getClass();
		
		System.out.println(s1.getName());
		System.out.println(s1.getSimpleName());
		System.out.println(s2.getName());
		System.out.println(s3.getName());
		
		Student stu1=(Student) s1.newInstance();//通过类的类型创建该类的实例对象 ，前提是该类必须存在一个无参构造方法
		
		Constructor con=s2.getConstructor(int.class,String.class,int.class);//取得指定参数类型的构造方法
		Student stu2=(Student) con.newInstance(1,"name",12);
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
		
		
	}
	
}
