package com.myapp.bbs;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.myapp.bbs.model.User;

@ControllerAdvice
public class Common {

	@ModelAttribute
	public void sharedData(Model model, HttpSession session) {
		// session에 인증된 user가 있으면 user의 이름을 모든 페이지에 전달
		User user = (User) session.getAttribute("user");
		
		if (user != null) { // user가 있으면
			model.addAttribute("userName", user.getName());
		}
	}
}
