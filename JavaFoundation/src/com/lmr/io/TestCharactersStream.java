package com.lmr.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class TestCharactersStream {

	public static void main(String[] args) {
		String headpath="D:\\TestIOData\\";
		try {
			WriterMethod(headpath+"chartxt.txt");
			ReaderMethod(headpath+"chartxt.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void WriterMethod(String path) throws IOException{
		
		File f=new File(path);
		Writer w=new FileWriter(f,false);
		
		w.write("hello world!");
		
		w.flush();//刷新输出流，强制清空缓存区
		w.close();
		
	}
	
	public static void ReaderMethod(String path) throws IOException{

		File f=new File(path);
		Reader r=new FileReader(f);
		
		int c;
		while((c=r.read())!=-1){//逐个字节读取
			System.out.print((char)c);
		}
		
		char[] buf=new char[1024];
		int len=0;
		while((len=r.read(buf))!=-1){
			System.out.println(new String(buf));
		}
		
		
		r.close();
		
	}
	
}
