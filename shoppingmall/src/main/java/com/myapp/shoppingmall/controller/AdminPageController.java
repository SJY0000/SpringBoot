package com.myapp.shoppingmall.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.shoppingmall.dao.PageRepository;
import com.myapp.shoppingmall.entities.Page;

@Controller
@RequestMapping("/admin/pages")
public class AdminPageController {

	@Autowired
	private PageRepository pageRepo;
	
	@GetMapping
	public String index(Model model) {
		List<Page> pages = pageRepo.findAll();
		model.addAttribute("pages", pages);
		return "admin/pages/index";
	}
	
	@GetMapping("/add")
	public String add(@ModelAttribute Page page) {
//		model.addAttribute("page", new Page());
		return "admin/pages/add";
	}
	
	@PostMapping("/add")
	public String add(@Valid Page page, BindingResult bindingResult) {
		//Validation 결과 Error가 있으면 이전페이지로 이동
		if (bindingResult.hasErrors()) {
			return "admin/pages/add";
		}
		return "redirect:admin/pages/add";
	}
}
