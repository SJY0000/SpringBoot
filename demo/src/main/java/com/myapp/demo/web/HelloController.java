package com.myapp.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 주소창에 주소를 적으면 안의 메소드가 요청을 받는다.
@RestController
// 주소창에 localhost:포트번호 /hello 이면 이 클래스로 온다
@RequestMapping("/hello")
public class HelloController {

	// get메소드로 / 들어오면 return
	// /hello 안에 /basic을 적으면 이 메소드를 return 함
	@GetMapping("/basic")
	public String sayHello() {
		
		
		return "<h1>헬로우 월드2</h1>";
	}
	
	@GetMapping("/korean")
	public String translate() {
		return "<h1>GetMapping 테스트 </h1>";
	}
	
	@GetMapping("/japan")
	public String translatejp() {
		return "<h1>GetMapping 테스트 </h1>";
	}
	
	@GetMapping("/form")
	public String form() {
		return "<form method=\"POST\" action=\"/hello/formPost\">\r\n"
				+ "	<p>\r\n"
				+ "		<strong>아이디</strong>\r\n"
				+ "		<input type=\"text\" name=\"name\" value=\"\">\r\n"
				+ "	</p>\r\n"
				+ "	<p>\r\n"
				+ "		<strong>비밀번호</strong>\r\n"
				+ "		<input type=\"password\" name=\"password\" value=\"\">\r\n"
				+ "	</p>\r\n"
				+ "	<p>\r\n"
				+ "		<strong>성별</strong>\r\n"
				+ "		<input type=\"radio\" name=\"gender\" value=\"남성\">남자\r\n"
				+ "		<input type=\"radio\" name=\"gender\" value=\"여성\">여자\r\n"
				+ "	</p>\r\n"
				+ "	<p>\r\n"
				+ "		<strong>응시분야</strong>\r\n"
				+ "		<input type=\"checkbox\" name=\"part\" value=\"영어\">영어\r\n"
				+ "		<input type=\"checkbox\" name=\"part\" value=\"수학\">수학\r\n"
				+ "	</p>\r\n"
				+ "	<p>\r\n"
				+ "		<input type=\"submit\" value=\"제출\">\r\n"
				+ "	</p>\r\n"
				+ "</form>";
	}
	
	// post 방식에 /formPost로 전송받을 때
	@PostMapping("/formPost")
	public String formpost(@RequestParam("name") String name,
							@RequestParam("password") String password,
							@RequestParam("gender") String gender,
							@RequestParam("part") String part) {
		
		return "아이디는 " + name + ", 비밀번호는 " + password + ", 성별은 " + gender + ", 응시과목은 " + part;
	}
	// post주소와 같아도 주소에 바로 넣는 get 방식이면 get이 실행됨
	@GetMapping("/formPost")
	public String formtest() {
		return "<h1>post와 같은 주소 </h1>";
	}
	// /{id} 주소에 들어가는 PathVarialble
	// getParmeter와 PathVariable은 유사하지만 다르다
	@GetMapping("/orders/{id}")
	public String order(@PathVariable String id) {
		
		return "주문 아이디는 : " + id;
	}
}
