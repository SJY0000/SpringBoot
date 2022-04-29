package com.myapp.bbs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.myapp.bbs.model.User;

// Interceptor 클래스를 만들고 HandlerInterceptor를 구현
// Login 한 후 계속해서 인증되었는지 확인한다.
public class LoginCheckInterceptor implements HandlerInterceptor {
	
	// preHandle 메소드 : Controller에 가기 전 Interceptor에서 Catch해서 작업 수행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(); // Session 불러오기
		User user = (User) session.getAttribute("user"); // User 타입으로 Cast
		
		if(user == null) { // Login이 안된 상태(인증이 안된 상태) => Login 페이지로 이동
			String url = session.getServletContext().getContextPath() + "/login";
			System.out.println("session.getServletContext() : " + session.getServletContext());
			System.out.println("session.getServletContext().getContextPath() : " + session.getServletContext().getContextPath());
			response.sendRedirect(url); // Login 페이지로 새로고침
			System.out.println("LoginInterceptor # preHandler() : 실패");
			return false;
		}
		System.out.println("LoginInterceptor # preHandler() : 통과");
		// 중요!!!! Interceptor 메소드에서 Return이 true면 통과, false면 차단
		return true;
	}
	
}
