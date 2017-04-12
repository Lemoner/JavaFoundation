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
		
		pro.store(stream, "first add");//将此 Properties 表中的属性列表（键和元素对）写入输出流，第二个参数是对属性列表的描述
		
		stream.close();
		
	}

	private static void ReadMethod() throws IOException {
		// TODO Auto-generated method stub
		
		File file=new File(path);
		FileInputStream stream=new FileInputStream(file);
		
		Properties pro=new Properties();
		
		pro.load(stream);//从输入流中读取属性列表
		
		Enumeration<?> en=pro.propertyNames();//返回属性列表中所有键的枚举
		while (en.hasMoreElements()) {
			Object object = (Object) en.nextElement();
			System.out.println(object+" + + "+pro.getProperty((String) object));
		}
		
		Iterator<String> iterator=pro.stringPropertyNames().iterator();//返回此属性列表中的键集，其中该键及其对应值是字符串
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println(key+" - - "+pro.getProperty(key));
		}
		
		stream.close();
		
	}
	
}
