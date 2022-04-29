package com.myapp.bbs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.myapp.bbs.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// Interceptor를 추가하는 메소드
		registry.addInterceptor(new LoginCheckInterceptor()) // 생성한 Interceptor 추가
				.addPathPatterns("/board/**")						// Interceptor를 적용할 Controller 주소
				.excludePathPatterns("/board/list", "/board/get");						// Interceptro를 적용하지 않을 Controller 주소
	}
}
