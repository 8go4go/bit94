package kr.heartof.springWeb_01.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@RequestMapping("/member/signup")
	public String showSignup() {
		return "member/signup";
	}
	
	public String processSignup() {
		// 회원가입 처리 및 처리 결과 페이지로 이동
		return "";
	}
	
	@RequestMapping("/member/login")
	public String showLogin() {
		return "member/login";
	}
	
	@RequestMapping("/member/loginConfirm")
	public boolean processLogin() {
		return false;
	}
	
	@RequestMapping("/member/memberinfo") 
	public String showMemberInfo(){
		return "member/memberinfo";
	}
	
	@RequestMapping("/member/modifyOk") 
	public String processModify(){
		return "member/modifyOk";
	}
	
	@RequestMapping("/admin/login") 
	public String showAdminLogin(){
		return "admin/adminLogin";
	}
	
}
