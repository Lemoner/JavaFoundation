package com.lmr.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

public class TestProperties {
	
	private static String path="D:\\TestIOData\\resultpro.properties";

	public static void main(String[] args) {
		
		try {
			
			WriteMethod();
			
			ReadMethod();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void WriteMethod() throws IOException {
		// TODO Auto-generated method stub
		
		
		File file=new File(path);
		FileOutputStream stream=new FileOutputStream(file);
		
		Properties pro=new Properties();
		pro.setProperty("id", "1");
		pro.setProperty("name", "Jack");
		pro.setProperty("age", "18");
		pro.setProperty("count", "10");
		
		pro.store(stream, "first add");//���� Properties ���е������б�����Ԫ�ضԣ�д����������ڶ��������Ƕ������б������
		
		stream.close();
		
	}

	private static void ReadMethod() throws IOException {
		// TODO Auto-generated method stub
		
		File file=new File(path);
		FileInputStream stream=new FileInputStream(file);
		
		Properties pro=new Properties();
		
		pro.load(stream);//���������ж�ȡ�����б�
		
		Enumeration<?> en=pro.propertyNames();//���������б������м���ö��
		while (en.hasMoreElements()) {
			Object object = (Object) en.nextElement();
			System.out.println(object+" + + "+pro.getProperty((String) object));
		}
		
		Iterator<String> iterator=pro.stringPropertyNames().iterator();//���ش������б��еļ��������иü������Ӧֵ���ַ���
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println(key+" - - "+pro.getProperty(key));
		}
		
		stream.close();
		
	}
	
}
