package com.myapp.shoppingmall.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 1. WebSecurityConfigurerAdapter 상속, 2. @EnableWebSecurity
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Security는 1. 인증(로그인) , 2. 허가(role에 따른 권한)
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 허가(rore에 따른 권한설정)
		http.authorizeHttpRequests()
//			.antMatchers("/category/**").hasAnyRole("USER", "ADMIN") // 카테고리 안의 페이지는 유저, 관리자 접근가능
//			.antMatchers("/admin/**").hasAnyRole("ADMIN")			// 관리자 안의 페이지는 관리지만 접근가능
			.antMatchers("/").permitAll();							// 누구나 접근 가능
		
	}
}
