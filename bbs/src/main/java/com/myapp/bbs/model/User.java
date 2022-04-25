package com.myapp.bbs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // 모든 변수로 생성자 만들기
//@NoArgsConstructor // 변수가 없는 기본생성자
public class User {

	private String email;
	private String password;
	private String name;
	
}
