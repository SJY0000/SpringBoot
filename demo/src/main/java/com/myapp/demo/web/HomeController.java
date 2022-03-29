package com.myapp.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myapp.demo.domain.User;

@Controller // @controller는 view를 찾음, return값으로 templaltes 폴더 안의 파일이름을 찾음
public class HomeController {

	// View와 Controller 사이의 데이터를 Model을 통해 전달
	@GetMapping("/")
	public String data(Model model) {
		// user 이름으로 User의 bean객체를 넣어서 전달
		model.addAttribute("user", new User());
		// model을 통해 index.html 페이지에 전달
		return "index";
	}
	
	// 매개변수로 받은 데이터를 view 페이지로 전달됨
	@PostMapping("/create")
	public String processFormData(User user, RedirectAttributes attr) {
//		System.out.println(user.toString());
		attr.addFlashAttribute("user", user);
		// /display페이지로 새로운 요청 
		// redirect는 데이터를 넘기지 않음(데이터를 넘기려면 RedirectAttributes 객체에 담아서 보내야함)
		return "redirect:/display"; 
	}
	
	@GetMapping("/display")
	public String displayFormData(User user) {
		
		
		return "result";
	}
}
