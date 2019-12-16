package com.lmr.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestURLConnection {

	public static void main(String[] args) {
		
		try {
			
//			String urlName="http://www.google.com";
			String urlName="http://www.baidu.com";
//			String urlName="http://horstmann.com";
			
			URL url=new URL(urlName);
//			Scanner sc=new Scanner(url.openStream());//获取该资源内容
//			
//			int n=0;
//			while(sc.hasNext()){
//				
//				String str = new String(sc.next().toString().getBytes(),"utf-8");//转码
//				
//				System.out.print(str);
//				
//				if(str.endsWith(">")){
//					System.out.println();
//				}
//				
//			}
			
			URLConnection connection=url.openConnection();//URLConnection可以获取更多的操作内容
			
			//设置请求属性操作必须放在connect()前
			connection.setDoOutput(true);//开启输出流，用于向服务器提交操作或数据
			
			connection.connect();
			
			Map<String, List<String>> headers=connection.getHeaderFields();
			
			for(Map.Entry<String, List<String>> entry:headers.entrySet()){
				System.out.println(entry.getKey()+" - - "+entry.getValue().toString());
			}
			
			System.out.println("----------------------------");
			System.out.println(connection.getContentType());
			System.out.println(connection.getContentLength());
			System.out.println(connection.getContentEncoding());
			System.out.println(connection.getConnectTimeout());
			System.out.println(connection.getDate());
			System.out.println(connection.getExpiration());
			System.out.println("----------------------------");
			
			Scanner sc=new Scanner(connection.getInputStream());
			
			int n=0;
			while(sc.hasNext()){
				
				String str = new String(sc.next().toString().getBytes(),"utf-8");//转码
				
				System.out.print(str);
				
				if(str.endsWith(">")){
					System.out.println();
				}
				
			}
			
//			PrintWriter pw=new PrintWriter(connection.getOutputStream());
//			pw.println("hello");
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
