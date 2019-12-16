package com.lmr.annotation;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SqlAnno {

	public static void main(String[] args) {
		
		SqlPerson sp1=new SqlPerson();
		sp1.setName("Jack");
		sp1.setAge(18);
		
		SqlPerson sp2=new SqlPerson();
		sp2.setId(1);
		sp2.setName("Jane");
		sp2.setEmail("123456789@qq.com");
		
		String sql1=QuerySql(sp1);
		System.out.println(sql1);
		
		String sql2=QuerySql(sp2);
		System.out.println(sql2);
		
	}

	private static String QuerySql(SqlPerson sp) {
		// TODO Auto-generated method stub
		
		StringBuilder sb=new StringBuilder();
		sb.append("select * from ");
		
		try {
			Class c=Class.forName("com.lmr.annotation.SqlPerson");
			
			//��ȡ���ϵ�ע�⣬�õ�����
			Boolean cflag=c.isAnnotationPresent(Table.class);
			if(cflag){
				Table table=(Table) c.getAnnotation(Table.class);
				sb.append(table.value());
			}
			
			sb.append(" where 1=1 ");
			
			//��ȡBean���е������ֶ�
			Field[] fs=c.getDeclaredFields();
			for(Field f:fs){
				
				//��ȡ�ֶ��ϵ�ע�⣬�õ����е��ֶ���
				String columnname = null;
				Boolean fflag=f.isAnnotationPresent(Column.class);
				if(fflag){
					Column column=f.getAnnotation(Column.class);
					columnname=column.value();
				}
				
				//��ȡ���ֶε�get����
				PropertyDescriptor pd=new PropertyDescriptor(f.getName(), c);
				Method getmethod=pd.getReadMethod();
				
				//��ȡ���ֶε�ֵ
				Object data=getmethod.invoke(sp);
//				f.setAccessible(true);
//				Object data=f.get(sp);
				
				//��ȡ���ֶε�����
				String type=pd.getPropertyType().getSimpleName();
				
				//ƴ��sql���
				if(type.equals("int")&&Integer.parseInt(data.toString())!=-1){
					sb.append("and "+columnname+"="+data+" ");
				}else if(type.equals("String")&&data!=null){
					sb.append("and "+columnname+"=\""+data+"\" ");
				}
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return sb.toString();
	}
	
}
