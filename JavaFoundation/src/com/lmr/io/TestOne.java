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
		
//		System.out.println(System.getProperty("user.dir"));//��ȡ��ǰ�ļ�Ŀ¼

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
		
		//һ���ֽ�һ���ֽڵĶ�ȡ
//		int b;
//		int len=0;
//		List<Byte> bytelist=new ArrayList<>();
//		while((b=fis.read())!=-1){//-1Ϊ������ʶ
//			System.out.print(b+" ");//��ӦΪascall��
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
//		System.out.println(new String(bytes,"utf-8"));//���Ǻ���������ת��
		
		//���ֽڶ�ȡ
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
		
		while(fis.read(bytes, 0, bytes.length)!=-1){//һ�ζ�ȡָ�����ȵ��ֽ�
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
		
//		FileOutputStream fos=new FileOutputStream(path);//����ԭ�ļ����ݣ��������
		FileOutputStream fos=new FileOutputStream(path, true);//��ԭ�л�����׷�ӣ�true��д���ļ�β��false��д���ļ�ͷ
		
		String str="hello,world!";
//		fos.write(str.getBytes());
		fos.write(str.getBytes("utf-8"));
		fos.close();
		
	}
	
}
