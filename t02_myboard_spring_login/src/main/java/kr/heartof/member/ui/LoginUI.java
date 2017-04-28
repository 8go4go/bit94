package kr.heartof.member.ui;

import java.util.Base64;
import java.util.List;
import java.util.Scanner;

import kr.heartof.member.dao.MemberDAO;
import kr.heartof.member.vo.InterestVO;
import kr.heartof.member.vo.MemberInterestVO;
import kr.heartof.member.vo.MemberVO;
import kr.heartof.member.vo.ProfessionVO;
import kr.heartof.member.vo.StatusVO;
import kr.heartof.member.vo.UserInfoVO;
import kr.heartof.member.vo.ZipVO;

public class LoginUI {
	private boolean isLogin = false;
	private Scanner sc = null;
	private MemberDAO dao = null;
	private String userid = null;
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
				try {
					findIDandPassword();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
					break;
				case 3: // register member
				try {
					registerMember();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
					break;
				case 4: // modify member
				try {
					modifyMember();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
					break;
				case 5: // view board
					break;
				case 6:
					userid = null;
					break;
			}
		}
	}
	
	private void modifyMember() throws Exception {
		if(userid != null) {
			UserInfoVO uiv = dao.userInfo(userid);
			
			System.out.println("1.성 : " + uiv.getLast_name());
			System.out.println("2.이름 : " + uiv.getFirst_name());
			System.out.println("3.전화번호 : " + uiv.getPhone());
			System.out.println("*.등록일 : " + uiv.getReg_date().toString());
			System.out.println("4.도시 : " + uiv.getCity());
			System.out.println("  .구 : " + uiv.getState());
			System.out.println("5.결혼 유무 : " + uiv.getStatus());
			System.out.println("6.관심사 : " + uiv.getInterest());
			System.out.println("7.수정 적용");
			System.out.println("수정할 부분의 번호를 입력하세요");
			int subMenu = getInputIntData();
			
			switch(subMenu) {
			case 1:   // 성
				break;
			case 2:   // 이름
				break;
			case 3:   // 전화번호
				break;
			case 4:   // 도시
				break;
			case 5:   // 결혼유무
				break;
			case 6:   // 관심사
				break;
			case 7:   // 수정 적용
				break;
			}
		} else {
			throw new Exception("로그인이 필요합니다. 먼저 로그인 해주세요");
		}
	}

	private void registerMember() throws Exception {
		MemberVO vo = new MemberVO();
		int member_id = dao.getMaxMember();
		vo.setMem_id(String.valueOf(member_id));
		
		System.out.println("아이디 입력하세요 ");
		vo.setUserid(getInputData());
		System.out.println("성을 입력하세요 ");
		vo.setFirst_name(getInputData());
		System.out.println("이름을 입력하세요 ");
		vo.setLast_name(getInputData());
		System.out.println("전화번호를 입력하세요 ");
		vo.setPhone(getInputData());
		System.out.println("핸드폰 번호 입력하세요 ");
		vo.setMobile(getInputData());
		System.out.println("패스워드 입력하세요 ");
		vo.setPassword(Base64.getEncoder().encodeToString(getInputData().getBytes()));
		System.out.println("이메일 입력하세요 ");
		vo.setEmail(getInputData());
		
		System.out.println("주소 중 번호를 선택하세요");
		List<ZipVO> zips = dao.selectZip();
		for(ZipVO zvo : zips) { System.out.printf("%d, %s, %s \n", zvo.getZip_id(), zvo.getCity(), zvo.getState());}
		vo.setZip_id(getInputData());
		
		System.out.println("직업 중 번호를 선택하세요");
		List<ProfessionVO> profs = dao.selectProfession();
		for(ProfessionVO zvo : profs) { System.out.printf("%d, %s\n", zvo.getProf_id(), zvo.getProf_name());}
		vo.setProf_id(getInputData());
		
		System.out.println("관심사 중 번호를선택하세요");
		List<InterestVO> inters = dao.selectInterest();
		for(InterestVO zvo : inters) { System.out.printf("%d, %s\n", zvo.getInterest_id(), zvo.getInterest());}
		MemberInterestVO ivo = new MemberInterestVO();
		ivo.setInterest_id(getInputIntData());
		ivo.setMem_id(member_id);
		
		System.out.println("결혼 유무 중 번호를 선택하세요");
		List<StatusVO> sts = dao.selectStatus();
		
		for(StatusVO zvo : sts) { System.out.printf("%d, %s\n", zvo.getStatus_id(), zvo.getStatus());}
		vo.setStatus_id(getInputData());
		
		dao.registerMember(vo, ivo);
	}
	
	private void findIDandPassword() throws Exception {
		System.out.println("(1. 아이디 찾기, 2. 패스워드 찾기 )");
		int subMenu = getInputIntData();
		switch(subMenu) {
			case 1:
				System.out.println("아이디 찾기 입니다. 이메일을 입력하세요");
				String email = getInputData();
				System.out.println("아이디 찾기 입니다. 전화번호를 입력하세요");
				String phone = getInputData();
				System.out.println("사용하시는 아뒤는 : " + dao.findId(email, phone) + "입니다.");
				
				break;
			case 2:
				System.out.println("패쓰워드 찾기 입니다. ID를 입력하세요");
				String id = getInputData();
				System.out.println("아이디 찾기 입니다. 전화번호를 입력하세요");
				phone = getInputData();
				System.out.println("아이디 찾기 입니다. 이메일을 입력하세요");
				email = getInputData();
				
				byte[] pass = Base64.getDecoder().decode(dao.findPass(id, email, phone));
				System.out.println("사용하시는 아뒤는 : " + new String(pass) + "입니다.");
				
				break;
		}
	}
	
	private void login() {
		System.out.println("아이디를 입력하세요");
		String id = getInputData();
		System.out.println("패스워드를 입력하세요");
		String password = getInputData();
		password = Base64.getEncoder().encodeToString(password.getBytes());
		
		boolean isResult = dao.login(id, password);
		
		if(isResult) {
			System.out.println("로그인 성공");
			userid = id;
		} else
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
		sb.append("6. 로그아웃").append("\n");
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
