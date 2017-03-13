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
	
	public ExternalPerson() {//无参构造器，必须有，不然无法进行反序列化
		// TODO Auto-generated constructor stub
//		System.out.println("必须要有无参构造器！！！！");
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

	// 在writeExternal之前执行，可以在序列化前对对象进行一些处理，比如加密。
    private Object writeReplace() throws ObjectStreamException {
    	this.setPassword(new StringBuffer(password).reverse().toString());//这里对password进行了反转处理
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

    // 在readExternal之后执行，可以在反序列化后对得到的对象进行一些处理，比如解密
    private Object readResolve() throws ObjectStreamException {
    	//此处可以写对password的解密处理
//        System.out.println("readresolve");
        return this;
    }

}
