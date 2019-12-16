package com.lmr.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestExternalizable {

	public static void main(String[] args) throws IOException {

		String headpath = "D:\\TestIOData\\";

		EWriteMethod(headpath + "externalperson.txt");

		EReadMethod(headpath + "externalperson.txt");

	}

	public static void EWriteMethod(String path) throws IOException {

		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		for (int i = 1; i < 10; i++) {
			ExternalPerson ep = new ExternalPerson("A" + i, 10 + i, "ABCD" + i);
			System.out.println(ep.toString());
			oos.writeObject(ep);
//			ep.writeExternal(oos);
		}
		System.out.println("----***************---------");
		
		oos.close();
		fos.close();

	}

	public static void EReadMethod(String path) throws IOException {

		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);

		while (true) {// ʹ�ô����쳣�ķ�ʽ���ж��ļ��Ƿ����

			try {
				ExternalPerson ep = (ExternalPerson) (ois.readObject());// �ļ���ȡ��Ϻ󣬻����쳣
				System.out.println(ep.toString());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("�ļ���ȡ���!");
				break;
			}

		}
		ois.close();
		fis.close();

	}

}
