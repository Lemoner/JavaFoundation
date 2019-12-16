package com.lmr.io;

import java.io.IOException;
import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {
		
//		SystemMethod();
//		ScannerMethod();
		DelimiterMethod();
	}
	
	public static void SystemMethod(){
		
		int b;
		System.out.println("-----------------Print:-----------------");
		try {
			while((b=System.in.read())!=1){
				System.out.print((char) b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void ScannerMethod(){
		
		Scanner s = new Scanner(System.in);
		System.out.println("请输入字符串：");
		while (true) {
			String line = s.nextLine();
			if (line.equals("exit")) {
				break;
			}
			System.out.println(">>>" + line);
		}

	}
	
	public static void DelimiterMethod(){
		
//		String str="123 456 789 a d e   fesa as";
		String str="baf,dji,ue.mcn\\adsf\\5e|7984/3d21.fa8,gtfd\\v13|a8,e4r";
		
		Scanner s=new Scanner(str);//默认按空格截取
		
		s.useDelimiter(",");//自定义分割符
//		s.useDelimiter(".");
		
		while(s.hasNext()){
			System.out.println(s.next());
		}
		
	}
	
}
