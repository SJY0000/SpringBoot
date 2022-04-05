package com.myapp.mobile.model.request;

import javax.validation.constraints.Size;

public class UpdateUserRequest {
	// User 객체에서 Email, Password 제외한 name만 Update함
	@Size(min = 2, message = "최소 2글자 이상 입력해주세요.")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
