package com.lmr.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestSerializable {

	public static void main(String[] args) throws IOException {
		
		String headpath="D:\\TestIOData\\";
		
		WriteMethod(headpath+"serialperson.txt");
		
		ReadMethod(headpath+"serialperson.txt");
		
	}
	
	public static void WriteMethod(String path) throws IOException{
		
		FileOutputStream fos=new FileOutputStream(path);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		for(int i=1;i<10;i++){
			SerialPerson sp=new SerialPerson("A"+i, 10+i,"aBc"+i);
			oos.writeObject(sp);
		}
		
//		List<SerialPerson> splist=new ArrayList<>();
//		for(int i=1;i<10;i++){
//			SerialPerson sp=new SerialPerson("A"+i, 10+i,"aBc"+i);
//			splist.add(sp);
//		}
//		oos.writeObject(splist);//ֱ��д�����list�����Ӧ�Ķ�ȡ��ʱ��ת���ĸ�ʽҲҪ��list
		
		oos.close();
		fos.close();
		
	}
	
	public static void ReadMethod(String path) throws IOException{
		
		FileInputStream fis=new FileInputStream(path);
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		while(true){//ʹ�ô����쳣�ķ�ʽ���ж��ļ��Ƿ����
			
			try {
				SerialPerson sp=(SerialPerson) ois.readObject();//�ļ���ȡ��Ϻ󣬻����쳣
				System.out.println(sp.toString());
				
			} catch (Exception  e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("�ļ���ȡ���!");  
                break;  
			}
			
		}
		
//		try {
//			List<SerialPerson> splist=(List<SerialPerson>) ois.readObject();//���ﷴ���л����ת����ʽҪ�����л�֮ǰ�ĸ�ʽһ��
//			
//			for(SerialPerson sp:splist){
//				System.out.println(sp.toString());
//			}
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		ois.close();
		fis.close();
		
	}
	
}
