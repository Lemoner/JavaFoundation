package com.lmr.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestOne {

	public static void main(String[] args) {
		
//		System.out.println(System.getProperty("user.dir"));//获取当前文件目录

		try {
//			FileInputMethod("D:\\TestIOData\\two.txt");
			FileOutputMethod("D:\\TestIOData\\two.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private static void FileInputMethod(String path) throws IOException{
		
		FileInputStream fis=new FileInputStream(path);
		
		//一个字节一个字节的读取
//		int b;
//		int len=0;
//		List<Byte> bytelist=new ArrayList<>();
//		while((b=fis.read())!=-1){//-1为结束标识
//			System.out.print(b+" ");//对应为ascall码
//			bytelist.add((byte) b);
//			if(++len%10==0){
//				System.out.println();
//			}
//		}
//		byte[] bytes=new byte[len];
//		for(int i=0;i<len;i++){
//			bytes[i]=bytelist.get(i);
//		}
////		System.out.println(new String(bytes));
//		System.out.println(new String(bytes,"utf-8"));//若是含有中文须转码
		
		//多字节读取
		byte[] bytes=new byte[1024];
//		while(fis.read(bytes)!=-1){
//			for(int i=0;i<bytes.length;i++){
//				System.out.print(bytes[i]+" ");
//				if(i%10==0){
//					System.out.println();
//				}
//			}
//			System.out.println();
//			System.out.println(new String(bytes));
//		}
		
		while(fis.read(bytes, 0, bytes.length)!=-1){//一次读取指定长度的字节
			for (int i = 0; i < bytes.length; i++) {
				System.out.print(bytes[i] + " ");
				if (i % 10 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			System.out.println(new String(bytes));
		}
		
		
		fis.close();
	}
	
	public static void FileOutputMethod(String path) throws IOException{
		
//		FileOutputStream fos=new FileOutputStream(path);//覆盖原文件内容，重新添加
		FileOutputStream fos=new FileOutputStream(path, true);//在原有基础上追加，true是写入文件尾，false是写入文件头
		
		String str="hello,world!";
//		fos.write(str.getBytes());
		fos.write(str.getBytes("utf-8"));
		fos.close();
		
	}
	
}
