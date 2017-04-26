package kr.heartof.member.ui;

import java.util.Base64;
import java.util.Scanner;

import kr.heartof.member.dao.MemberDAO;

public class LoginUI {
	private boolean isLogin = false;
	private Scanner sc = null;
	private MemberDAO dao = null;
	
	public LoginUI() {
		sc = new Scanner(System.in);
	}
	
	public void setMemberDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		run();
	}
	
	private void run() {
		while(!isLogin) {
			int menu = -1;
			showMenu();
			System.out.println("원하시는 번호를 선택하세요");
			try {
				menu = getInputIntData();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}
			
			switch(menu) {
				case 1: // login
					login();
					break;
				case 2: // id/password 찾기
					break;
				case 3: // register member
					break;
				case 4: // modify member
					break;
				case 5: // view board
					break;
			}
		}
	}
	
	private void login() {
		System.out.println("아이디를 입력하세요");
		String id = getInputData();
		System.out.println("패스워드를 입력하세요");
		String password = getInputData();
		password = Base64.getEncoder().encodeToString(password.getBytes());
		
		boolean isResult = dao.login(id, password);
		
		if(isResult)
			System.out.println("로그인 성공");
		else
			System.out.println("아이디 또는 패스워드를 확인하세요");
			
			
		
	}
	
	private void showMenu() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("-----------------").append("\n");
		sb.append("1. 로그인").append("\n");
		sb.append("2. 아이디패스워드 찾기").append("\n");
		sb.append("3. 회원가입").append("\n");
		sb.append("4. 회원정보수정").append("\n");
		sb.append("5. 게시판 보기").append("\n");
		sb.append("-----------------\n");
		sb.append("메뉴 중 처리할 항목을 선택하세요 : ");

		System.out.println(sb.toString());
	}

	private String getInputData() {
		return sc.nextLine();
	}
	
	private int getInputIntData() throws Exception {
		return Integer.parseInt(sc.nextLine());
	}

	public void close() {
		sc.close();
	}
}
