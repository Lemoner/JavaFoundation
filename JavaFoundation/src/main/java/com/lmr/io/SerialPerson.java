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

//	private transient int id;// transient类型，瞬时变量，不会被序列化
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

	//在序列化前执行，可对要进行序列化的对象进行处理
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		in.defaultReadObject();
//		password = "456";
	}

	//在反序列化后执行
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
//		out.writeObject(password);
	}

}
