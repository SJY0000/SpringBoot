package com.myapp.demo.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.demo.domain.Product;

@RestController
@RequestMapping("/user") // https://localhost:8070/user
public class UserController {
	@GetMapping("/{id}")
	public String userid(@PathVariable String id) {
		return "유저아이디 : " + id;
	}
	
	@GetMapping("/{id}/contact")
	public String displayContact(@PathVariable String id,
						@RequestParam(value = "phone", defaultValue = "폰 없음") String phone) {
		
		return "유저아이디는 " + id + " 전화번호는 " + phone;
	}
	
	// 리스트 리턴해보기 => 제이슨 형식으로 변환되어서 출력됨
	@GetMapping("/{id}/items")
	public List<String> displayUserItems() {
		return Arrays.asList("가방","노트북","신발","태블릿");
	}
	
	// 객체를 리턴해보기 => 제이슨 형식으로 변환되어서 출력됨
	@GetMapping("/{id}/products")
	public List<Product> displayUserProducts() {
		return Arrays.asList(new Product(1, "모자", 5000),
								new Product(2, "가방", 20000),
								new Product(3, "노트북", 18000000),
								new Product(4, "태블릿", 1000000));
	}
}
