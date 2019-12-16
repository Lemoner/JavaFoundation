package com.lmr.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialPerson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 500670620466089114L;
	/**
	 * 
	 */

//	private transient int id;// transient���ͣ�˲ʱ���������ᱻ���л�
	private int id;
	private static int count = 0;
	private String name;
	private int age;
	private String password;

	public SerialPerson(String name, int age, String password) {
		// TODO Auto-generated constructor stub
		id = ++count;
		this.name = name;
		this.age = age;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SerialPerson [id=" + id + ", name=" + name + ", age=" + age + ", password=" + password + "]";
	}

	//�����л�ǰִ�У��ɶ�Ҫ�������л��Ķ�����д���
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		in.defaultReadObject();
//		password = "456";
	}

	//�ڷ����л���ִ��
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
//		out.writeObject(password);
	}

}
