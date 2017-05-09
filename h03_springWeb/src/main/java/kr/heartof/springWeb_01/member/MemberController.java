package kr.heartof.springWeb_01.member;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.heartof.springWeb_01.command.member.MemberCommandImpl;
import kr.heartof.springWeb_01.vo.user.UserVO;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberCommandImpl command;
	
//	public void setCommand(MemberCommandImpl command) {
//		this.command = command;
//	}
	
	@RequestMapping("/member/signup")
	public String showSignup() {
		return "member/signup";
	}
	
	@RequestMapping(value="/member/signupConfirm", method = RequestMethod.POST)
	@ResponseBody
	public UserVO processSignup(UserVO reqUser) {
		// 회원가입 처리 및 처리 결과 페이지로 이동
		return reqUser;
	}
	
	@RequestMapping("/member/login")
	public String showLogin() {
		return "member/login";
	}
	
	@RequestMapping(value="/member/loginConfirm", method = RequestMethod.POST)
	@ResponseBody
	public UserVO processLogin(HttpSession session, UserVO reqUser) {
		logger.info("processLogin");
		logger.info("USERID : " + reqUser.getUSRID());
		logger.info("PASSWD : " + reqUser.getPASSWD());
		session.setAttribute("user", reqUser);
		return reqUser;
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
