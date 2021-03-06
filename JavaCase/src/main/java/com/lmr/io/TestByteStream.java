package com.lmr.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

public class TestByteStream {

	public static void main(String[] args) {
		
//		System.out.println(System.getProperty("user.dir"));//获取当前文件目录
		
		String headpath="D:\\TestIOData\\";

		try {
			FileInputMethod("D:\\TestIOData\\two.txt");
//			FileOutputMethod("D:\\TestIOData\\two.txt");
			
//			CopyFileMethod(headpath+"one.txt", headpath+"three.txt");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void FileInputMethod(String path) throws IOException{
		
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
		while(fis.read(bytes)!=-1){
//			for(int i=0;i<bytes.length;i++){
//				System.out.print(bytes[i]+" ");
//				if(i%10==0){
//					System.out.println();
//				}
//			}
			System.out.println();
			System.out.println(new String(bytes));
		}
		
//		while(fis.read(bytes, 0, bytes.length)!=-1){//一次读取指定长度的字节
//			for (int i = 0; i < bytes.length; i++) {
//				System.out.print(bytes[i] + " ");
//				if (i % 10 == 0) {
//					System.out.println();
//				}
//			}
//			System.out.println();
//			System.out.println(new String(bytes));
//		}
		
		
		fis.close();
	}
	
	public static void FileOutputMethod(String path) throws IOException{
		
//		FileOutputStream fos=new FileOutputStream(path);//覆盖原文件内容，重新添加
		FileOutputStream fos=new FileOutputStream(path, true);//在原有基础上追加，true是写入文件尾，false是写入文件头
		//换行为\r\n
		
		String str="hello,world!";
//		fos.write(str.getBytes());
		fos.write(str.getBytes("utf-8"));
		fos.close();
		
	}
	
	public static void CopyFileMethod(String srcpath,String destpath) throws IOException{
		
		File srcfile=new File(srcpath);
		File destfile=new File(destpath);
		
		if(!srcfile.exists()){
			System.out.println(srcpath+"文件不存在");
		}
		
		FileInputStream srcfis=new FileInputStream(srcfile);
		FileOutputStream destfos=new FileOutputStream(destfile);
		
		byte[] bytes=new byte[1024];
		while(srcfis.read(bytes)!=-1){
			destfos.write(bytes);//使用数组太大，可能会造成文件末尾添加了无用的null字符串
			destfos.flush();//清除输出流
		}
		
		srcfis.close();
		destfos.close();
		
	}
	
}
