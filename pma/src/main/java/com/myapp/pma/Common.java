package com.myapp.pma;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice // 모든 Controller에 적용(모든 주소에 적용)
public class Common {

	// 각 Controller가 화면(뷰)에 보내는 Model객체에 추가
	@ModelAttribute
	public void sharedData(Model model, Principal principal) {
		
		// Principal은 Security인증시 인증된 유저정보를 담고 있는 객체
		if (principal != null) {
			model.addAttribute("principal", principal.getName()); // 인증 유저의 유저네임을 전달
		}
	}
}
