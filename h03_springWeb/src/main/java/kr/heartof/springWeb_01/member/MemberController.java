package kr.heartof.springWeb_01.member;

import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.heartof.springWeb_01.command.member.MemberCommandImpl;
import kr.heartof.springWeb_01.vo.user.CompanyUserVO;
import kr.heartof.springWeb_01.vo.user.PrivateUserVO;
import kr.heartof.springWeb_01.vo.user.UserVO;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberCommandImpl command;

	// public void setCommand(MemberCommandImpl command) {
	// this.command = command;
	// }

	@RequestMapping("/member/signup")
	public String showSignup() {
		return "member/signup";
	}

	//
	// @RequestMapping(value="/member/signupConfirm/company", method =
	// RequestMethod.POST)
	// @ResponseBody
	// public CompanyUserVO processSignupCompany(CompanyUserVO reqUser) {
	// // 회원가입 처리 및 처리 결과 페이지로 이동
	// logger.info("processSignupCompany : " + reqUser.getUSR_CD());
	// command.joinMember(reqUser);
	// return reqUser;
	// }
	//
	// @RequestMapping(value="/member/signupConfirm/private", method =
	// RequestMethod.POST)
	// @ResponseBody
	// public PrivateUserVO processSignupPrivate(PrivateUserVO reqUser) {
	// // 회원가입 처리 및 처리 결과 페이지로 이동
	// logger.info("processSignupPrivate : " + reqUser.getUSR_CD());
	// command.joinMember(reqUser);
	// return reqUser;
	// }

	@RequestMapping(value = "/member/signupConfirm/company", method = RequestMethod.POST)
	@ResponseBody
	public CompanyUserVO processSignupCompany(MultipartHttpServletRequest multi, CompanyUserVO vo) throws Exception {
		// 회원가입 처리 및 처리 결과 페이지로 이동
		logger.info("processSignupCompany : ");
		// 저장 경로 설정
		String root = multi.getSession().getServletContext().getRealPath("/");
		String path = root + "resources/upload/";

		String newFileName = ""; // 업로드 되는 파일명

		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdir();
		}

		Iterator<String> files = multi.getFileNames();
		while (files.hasNext()) {
			String uploadFile = files.next();

			MultipartFile mFile = multi.getFile(uploadFile);
			String fileName = mFile.getOriginalFilename();
			logger.info("실제 파일 이름 : " + fileName);
			newFileName = System.currentTimeMillis() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
			logger.info("newFileName : " + newFileName);
			try {
				mFile.transferTo(new File(path + newFileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		command.joinMember(vo);
		
		return vo;
	}

	@RequestMapping(value = "/member/signupConfirm/private", method = RequestMethod.POST)
	public PrivateUserVO processSignupPrivate(HttpServletRequest req, PrivateUserVO reqUser) throws Exception {
		// 회원가입 처리 및 처리 결과 페이지로 이동
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
		logger.info("processSignupPrivate : ");
		// 저장 경로 설정
		String root = multi.getSession().getServletContext().getRealPath("/");
		String path = root + "resources/upload/";

		String newFileName = ""; // 업로드 되는 파일명

		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdir();
		}

		Iterator<String> files = multi.getFileNames();
		while (files.hasNext()) {
			String uploadFile = files.next();

			MultipartFile mFile = multi.getFile(uploadFile);
			String fileName = mFile.getOriginalFilename();
			logger.info("실제 파일 이름 : " + fileName);	
			newFileName = System.currentTimeMillis() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
			logger.info("newFileName : " + newFileName);
			try {
				mFile.transferTo(new File(path + newFileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		command.joinMember(reqUser);
		
		return reqUser;
	}

	@RequestMapping("/member/login")
	public String showLogin() {
		return "member/login";
	}

	@RequestMapping(value = "/member/loginConfirm", method = RequestMethod.POST)
	@ResponseBody
	public UserVO processLogin(HttpSession session, UserVO reqUser) {
		logger.info("processLogin");
		reqUser = command.isLogin(reqUser);

		if (reqUser != null) {
			session.setAttribute("user", reqUser);
			return reqUser;
		} else {
			return null;
		}
	}

	@RequestMapping("/member/memberinfo")
	public String showMemberInfo() {
		return "member/memberinfo";
	}

	@RequestMapping("/member/modifyOk")
	public String processModify() {
		return "member/modifyOk";
	}

	@RequestMapping("/admin/login")
	public String showAdminLogin() {
		return "admin/adminLogin";
	}

}
