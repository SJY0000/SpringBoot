package com.myapp.mobile.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequest {

	@NotBlank(message = "이름을 입력해주세요.")
	private String name;
	@NotBlank(message = "이메일을 입력해주세요.")
	@Email
	private String email;
	@NotBlank(message = "비밀번호를 입력해주세요.")
	@Size(min = 4, max = 10, message = "최소 4글자 최대 10글자 이내로 입력해주세요.")
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
}
