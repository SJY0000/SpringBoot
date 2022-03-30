package com.myapp.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp.pma.dao.UserAccountRepository;
import com.myapp.pma.entities.UserAccount;

@Controller
public class SecurityController {

	@Autowired
	private UserAccountRepository userRepo;
	
	// 암호화는 저장할 때와 인증할때 필요함
	@Autowired
	private BCryptPasswordEncoder bEncoder;
	
	// 가입하기 화면 표시
	@GetMapping("/register")
	public String register(Model model) {
		UserAccount userAccount= new UserAccount();
		model.addAttribute("userAccount", userAccount);
		return "security/register";
	}
	
	@PostMapping("/register/save")
	public String saveUser(Model model, UserAccount user) {
		//비밀번호 암호화 후 저장
		// 넘어온 user정보에서 비밀번호만 얻어서 BCryptPasswordEncoder로 인코딩한 후 저장
		user.setPassword(bEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return "redirect:/";
	}
}
