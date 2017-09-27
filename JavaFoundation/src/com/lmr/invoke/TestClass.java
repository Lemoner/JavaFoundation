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
		
//		Field[] fields=c.getFields();//��ȡpublic���͵ĳ�Ա����
		Field[] fields=c.getDeclaredFields();//��Ա������Ϣ,��ȡȫ��
		
		System.out.println("----------��Ա����----------");
		for(Field f:fields){
			
			int mod=f.getModifiers();
			String modtype=Modifier.toString(mod);//����������
			
			System.out.println(modtype+" "+f.getType().getSimpleName()+" "+f.getName());
			
		}
		
		Constructor[] constructors=c.getDeclaredConstructors();//��ȡ���캯����Ϣ
		System.out.println("----------���캯��----------");
		for(Constructor con:constructors){
			
			String name=con.getName();//������
			Class[] paramterType=con.getParameterTypes();//�����в�������
			
			int mod=con.getModifiers();
			String modtype=Modifier.toString(mod);//����������
			
			System.out.print(modtype+" "+name+" (");
			for(Class p:paramterType){
				System.out.print(p.getSimpleName()+" ");
			}
			System.out.println(")");
			
		}
		
		Method[] methods=c.getMethods();//��ȡ����������Ϣ
		System.out.println("-----------����-----------");
		for(Method m:methods){
			
			String name=m.getName();//������
			Class returnType=m.getReturnType();//������������
			Class[] paramterType=m.getParameterTypes();//�����в�������
			
			int mod=m.getModifiers();
			String modtype=Modifier.toString(mod);//����������
			
			System.out.print(modtype+" "+returnType.getSimpleName()+" "+name+" (");
			for(Class p:paramterType){
				System.out.print(p.getSimpleName()+" ");
			}
			System.out.println(")");
		}
		
	}

	private static void initClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		
		//����ʵ����ʽ
		Class s1=Class.forName("com.lmr.invoke.Student");
		
		Class s2=Student.class;
		
		Student s=new Student(1,"1",1);
		Class s3=s.getClass();
		
		System.out.println(s1.getName());
		System.out.println(s1.getSimpleName());
		System.out.println(s2.getName());
		System.out.println(s3.getName());
		
		Student stu1=(Student) s1.newInstance();//ͨ��������ʹ��������ʵ������ ��ǰ���Ǹ���������һ���޲ι��췽��
		
		Constructor con=s2.getConstructor(int.class,String.class,int.class);//ȡ��ָ���������͵Ĺ��췽��
		Student stu2=(Student) con.newInstance(1,"name",12);
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
		
		
	}
	
}
