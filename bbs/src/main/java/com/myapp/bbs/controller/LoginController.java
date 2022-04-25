package com.myapp.bbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp.bbs.model.Login;
import com.myapp.bbs.model.User;
import com.myapp.bbs.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public String getLoginView(@ModelAttribute Login login) {
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(Login login, Model model, HttpSession session ) {
		loginService.authenticate(login); // 인증메소드 실행 (실패 시 에러메시지 입력됨)
		
		if (login.getError() != null) { 
			model.addAttribute("message", login.getError());
			return "login";
		} else {
			User user = loginService.findUserByEmail(login.getEmail());
			session.setAttribute("user", user);
			return "redirect:/board/list";
		}
	}
}
