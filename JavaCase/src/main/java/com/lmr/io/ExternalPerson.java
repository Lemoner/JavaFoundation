package com.lmr.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class ExternalPerson implements Externalizable{
	
	private int id=0;
	private static int count=0;
	private String name="";
	private int age=0;
	private String password="";
	
	public ExternalPerson() {//�޲ι������������У���Ȼ�޷����з����л�
		// TODO Auto-generated constructor stub
//		System.out.println("����Ҫ���޲ι�������������");
	}
	
	public ExternalPerson(String name,int age,String password) {
		// TODO Auto-generated constructor stub
		id=++count;
		this.name=name;
		this.age=age;
		this.password=password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "ExternalPerson [id=" + id + ", name=" + name + ", age=" + age + ", password=" + password + "]";
	}

	// ��writeExternal֮ǰִ�У����������л�ǰ�Զ������һЩ����������ܡ�
    private Object writeReplace() throws ObjectStreamException {
    	this.setPassword(new StringBuffer(password).reverse().toString());//�����password�����˷�ת����
//        System.out.println("writeReplace");
        return this;
    }

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(id);
		out.writeObject(name);
		out.writeObject(age);
		out.writeObject(password);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		id=(int) in.readObject();
		name=(String) in.readObject();
		age=(int) in.readObject();
		password=(String) in.readObject();
	}

    // ��readExternal֮��ִ�У������ڷ����л���Եõ��Ķ������һЩ�����������
    private Object readResolve() throws ObjectStreamException {
    	//�˴�����д��password�Ľ��ܴ���
//        System.out.println("readresolve");
        return this;
    }

}
