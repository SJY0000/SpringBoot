package com.myapp.pma.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// Security 사용순서
//1. Security 설정을 위해서 WebSecurityConfigurerAdapter 상속 받음
//2. 어노테이션 @EnableWebSecurity
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource; // MySQL DB와 연결
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; // 패스워드 인코딩 객체
	
	@Override // 3. 인증
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 메모리에 아이디, 비밀번호, 역할(권한)설정
		auth.jdbcAuthentication()
			.usersByUsernameQuery("select username,password,enabled from user_accounts where username = ? ") // DB에 있는지 확인
			.authoritiesByUsernameQuery("select username,role from user_accounts where username = ? ")
			.dataSource(dataSource)
			.passwordEncoder(bCryptPasswordEncoder); // 암호화된 패스워드를 디코딩해서 입력된 비밀번호와 비교
	}
	
	@Override // 4. 허가
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/projects/new").hasRole("ADMIN") // 새 프로젝트는 관리자만
			.antMatchers("/projects/save").hasRole("ADMIN")
			.antMatchers("/employees/new").hasRole("ADMIN") // 새 직원은 관리자만
			.antMatchers("/employees/save").hasRole("ADMIN")
			.antMatchers("/employees/").authenticated() // 인증된 유저
			.antMatchers("/projects/").authenticated()
			.antMatchers("/","/**").permitAll()				// 누구든 접근 가능
			.and()
			.formLogin(form -> form.loginPage("/login")
									.permitAll()) // 커스텀 로그인페이지 사용
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")); // 로그아웃 추가, 로그인 페이지를 새로 만들면 로그아웃도 새로 설정
	
		
		// Security에서는 기본적으로 csrf 방지가 적용중
//		http.csrf().disable(); // 사용자 의도치 않게 행동하는 것을 방지, save 후 redirect 하는 과정에서 csrf 룰에 위배되어 에러 출력
	}
}
