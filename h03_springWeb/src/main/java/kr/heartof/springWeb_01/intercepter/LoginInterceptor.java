package kr.heartof.springWeb_01.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.heartof.springWeb_01.vo.user.UserVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		if(session == null) {
			response.sendRedirect("/member/login");
			return false;
		} else {
			UserVO user =  (UserVO)session.getAttribute("user");
			
			if(user ==  null) {
				response.sendRedirect("/member/login");
				return false;
			}
		}
		return true;
	}
}
