package com.lmr.net;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class TestPost {

	public static void main(String[] args) throws IOException {
		
//		Properties props=new Properties();
//		
//		try {
//			InputStream in =Files.newInputStream(Paths.get(args[0]));
//			props.load(in);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Map<Object, Object> map=new HashMap<>();
		map.put("url", "http://www.apta.gov.cn/ProfTech_NoticeIndex/ProfTechActivityList");
		map.put("pi", "3");
//		map.put("url", "http://tieba.baidu.com/p/4999761486");
//		map.put("pn", 3);

//		map.put("url", "https://www.zhihu.com/");
//		map.put("fullname", "123");
//		map.put("phone_name", "456");
//		map.put("password", "789");
		
		String url=map.remove("url").toString();
		String result=doPost(url, map);
		System.out.println(new String(result.toString().getBytes(),"utf-8"));
		
		File f=new File("D://tets.txt");
		Writer w=new FileWriter(f,false);
		
		w.write(new String(result.toString().getBytes(),"utf-8"));
		
		w.flush();//刷新输出流，强制清空缓存区
		w.close();
		
		
	}
	
	public static String doPost(String urlString,Map<Object,Object> nameValuePairs) throws IOException{
		
		URL url=new URL(urlString);
		HttpURLConnection connection=(HttpURLConnection)url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36"); 
		
		OutputStream output=connection.getOutputStream();
		PrintWriter pw=new PrintWriter(output);
		
		try{
			
			boolean first=true;
			
			for(Map.Entry<Object, Object> pair:nameValuePairs.entrySet()){
				if(first){
					first=false;
				}
				else{
					pw.print('&');
				}
				String name=pair.getKey().toString();
				String value=pair.getValue().toString();
				pw.print(name);
				pw.flush();
				pw.print('=');
				pw.flush();
				pw.print(URLEncoder.encode(value, "utf-8"));
				pw.flush();
				
				
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		StringBuilder response=new StringBuilder();
		
		try {
			
			InputStream input=connection.getInputStream();
			Scanner sc=new Scanner(input);
			
			while(sc.hasNextLine()){
				response.append(sc.nextLine());
				response.append("\n");
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			
			if(!(connection instanceof HttpURLConnection)){
				throw e;
			}
			
			InputStream err=((HttpURLConnection)connection).getErrorStream();
			
			if(err==null){
				throw e;
			}
			Scanner sc=new Scanner(err);
			while(sc.hasNextLine()){
				response.append(sc.nextLine());
				response.append("\n");
			}
			
		}
		
		return response.toString();
	}
	
}
