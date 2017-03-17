package com.lmr.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.lmr.test.Student;

public class TestRandomAccessFile {

	public static void main(String[] args) {
		
		String headpath="D:\\TestIOData\\";
		
		try {
			WriteMethod(headpath+"randomaccess.txt");
			ReadMethod(headpath+"randomaccess.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void WriteMethod(String path) throws IOException{
		
		RandomAccessFile raf=new RandomAccessFile(path, "rw");
		
		Student s1=new Student(1, "A", 15);//一个字符两字节，in型数据4字节。
		Student s2=new Student(2, "B", 13);
		Student s3=new Student(3, "C", 16);
		
		System.out.println(s1.toString().length());
		System.out.println(s1.toString().getBytes().length);
		raf.write(s1.toString().getBytes());
		raf.seek(60);//设置文件指针偏移量，在该位置发生下一个读取或写入操作，是覆盖式操作，会将原有位置上的数据覆盖掉。要想实现在任意位置追加数据，须先新建一个缓冲区临时空间，把追加位置后的数据保存起来，追加完成后，再将该数据写入
		raf.write(s2.toString().getBytes());
		raf.write(s3.toString().getBytes());
		
//		raf.writeUTF(s1.toString());
//		raf.writeUTF("\r\n");
//		raf.writeUTF(s2.toString());
//		raf.writeUTF("\r\n");
//		raf.writeUTF(s3.toString());
//		raf.writeUTF("\r\n");
		
		raf.close();
	}
	
	public static void ReadMethod(String path) throws IOException{
		
		RandomAccessFile raf=new RandomAccessFile(path, "r");
		
		byte[] bytes=new byte[30];
//		while(raf.read(bytes)!=-1){
//			System.out.print(new String(bytes));
//		}
		
		raf.read(bytes);
		System.out.println(new String(bytes));
		raf.read(bytes);
		System.out.println(new String(bytes));
		raf.read(bytes);
		System.out.println(new String(bytes));
		System.out.println(raf.getFilePointer());
		raf.seek(60);
		raf.read(bytes);
		System.out.println(new String(bytes));
		raf.read(bytes);
		System.out.println(new String(bytes));
		
//		String s;
//		while((s=raf.readLine() )!= null){
//			System.out.println(s);
//		}
//		while((s=raf.readUTF()) != null){
//			System.out.print(s);
//		}
		
		raf.close();
	}
	
}
