package com.myapp.mybatis.model;

public class User {

	private String Id;
	private String name;
	private String phone;
	private String address;
	
	public User(String id, String name, String phone, String address) {
		super();
		Id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	// lombok 라이브러리 설치 안해서 get,set,constructor 직접 만들어야함
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
