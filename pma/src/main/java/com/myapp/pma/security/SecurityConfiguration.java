package com.myapp.pma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
// Security 설정을 위해서 WebSecurityConfigurerAdapter 상속 받음
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override // 인증
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 메모리에 아이디, 비밀번호, 역할(권한)설정
		auth.inMemoryAuthentication()
			.withUser("admin").password(getPasswordEncoder().encode("1234")).roles("ADMIN")
			.and()
			.withUser("asd").password(getPasswordEncoder().encode("asd")).roles("USER");
		
	}
	@Bean // 패스워드 암호화 객체
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance(); // 테스트용 비밀번호 암호화(실제론 안됨)
	}
	
	@Override // 허가
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.antMatchers("/projects/new").hasRole("ADMIN") // 새 프로젝트는 관리자만
			.antMatchers("/projects/save").hasRole("ADMIN")
			.antMatchers("/employees/new").hasRole("ADMIN") // 새 직원은 관리자만
			.antMatchers("/employees/save").hasRole("ADMIN")
			.antMatchers("/employees/").authenticated() // 인증된 유저
			.antMatchers("/projects/").authenticated()
			.antMatchers("/").permitAll()				// 누구든 접근 가능
			.and()
			.formLogin();									// 로그인창 사용
		
		// Security에서는 기본적으로 csrf 방지가 적용중
//		http.csrf().disable(); // 사용자 의도치 않게 행동하는 것을 방지, save 후 redirect 하는 과정에서 csrf 룰에 위배되어 에러 출력
	}
}
