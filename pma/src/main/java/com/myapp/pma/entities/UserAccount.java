package com.myapp.pma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//테이블 자동생성을 사용하지 않고 DB에 테이블을 직접 생성해서 클래스 이름과 다르기 때문에 적어줘야함)
@Table(name = "user_accounts") 
public class UserAccount {
	@Id	// 자동증가
	@GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동으로 생성
	@Column(name = "user_id") // 테이블의 Column 이름과 변수명이 다르기 때문에 일치시키기 위해 적어줘야함
	private long userId;
	
	@Column(name = "username") // 테이블의 Column 이름과 변수명이 다르기 때문에 일치시키기 위해 적어줘야함
	private String userName;
	
	private String email;
	private String password;
	private String role = "ROLE_USER";
	private boolean enabled = true;
	
	public UserAccount() {
		// 빈 유저 객체 생성시 role은 유저, enable은 true
		this.role = "ROLE_USER";
		this.enabled = true;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
