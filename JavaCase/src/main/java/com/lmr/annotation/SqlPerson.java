package com.lmr.annotation;

@Table("Person")
public class SqlPerson {

	@Column("Id")
	private int id=-1;
	
	@Column("Name")
	private String name;
	
	@Column("Age")
	private int age=-1;
	
	@Column("City")
	private String city;
	
	@Column("Email")
	private String email;
	
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
