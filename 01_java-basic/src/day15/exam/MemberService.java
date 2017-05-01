package day15.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MemberService {
	private boolean isExit = false;
	private Scanner sc;
	private Map<String, User> map;
	private String userFile = "data/user.txt";
	private User currentUser;
	private MailService mail;
	public MemberService() throws IOException {
		sc = new Scanner(System.in);
		map = new HashMap<String, User>();
		load();
	}
	
	private void load() throws IOException {
		if(new File(userFile).exists()) {
			BufferedReader bf = new BufferedReader(new FileReader(userFile));
			String data="";
			while((data = bf.readLine()) != null) {
				String datas[] = data.split(":");
				map.put(datas[0], new User(datas[0],datas[1],datas[2],datas[3],datas[4], datas[5], datas[6]));
			}
			bf.close();
		}
	}
	
	public void serivce() throws IOException {
		while(!isExit) {
			showMenu();
			int menu = getInputInt();
			switch(menu) {
			case 1:
				register();
				break;
			case 2:
				login();
				break;
			case 3:
				findPassword();
				break;
			case 4:
				exit();
				break;
			}
		}
	}
	
	private void findPassword() {
		// TODO Auto-generated method stub
		System.out.println("비밀번호 찾기 메뉴를 선택하셨습니다. ");
		System.out.println("비밀번호를 찾을 아이디를 입력해주세요.");
		String id = getInput();
		Set<String> keys = map.keySet();
		for(String key : keys) {
			if(key.compareTo(id) == 0) {
				User user = map.get(key);
				System.out.println("비밀번호 힌트를 입력해주세요.");
				String hint = getInput();
				if(user.getHint().compareTo(hint) == 0) {
					System.out.println("∴ 비밀번호 찾기에 성공하셨습니다 ∴");
					System.out.println("-----------------------");
					System.out.println("아이디 : " + user.getEmail());
					System.out.println("비밀번호 : " + user.getPassword());
					System.out.println("-----------------------");
					break;
				}
			}
		}
	}

	private void login() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("email계정으로 로그인.");
		System.out.print("아이디를 입력해주세요 : ");
		String email = getInput();
		System.out.print("비밀번호를 입력해주세요 : ");
		String password = getInput();
		
		if(isLogin(email, password)) {
			mail = new MailService(currentUser);
			mail.mailService();
		} else {
			System.out.println("∴아이디나 비밀번호가 바르게 입력되지 않았습니다∴");
			System.out.println("다시 로그인해주세요.");
		}
	}
	
	private boolean isLogin(String id, String password) {
		Set<String> keys = map.keySet();
		for(String key : keys) {
			if(key.compareTo(id) == 0) {
				User user = map.get(key);
				if(user.getPassword().compareTo(password) == 0) {
					currentUser = user;
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	private void register() {
		// TODO Auto-generated method stub
		System.out.println("∴E-mail 계정 만들기∴ ");
		System.out.print("아이디를 입력해주세요 : ");
		String email = getInput();
		System.out.print("비밀번호를 입력하세요 : ");
		String password = getInput();
		System.out.print("비밀번호 힌트를 입력하세요 : ");
		String hint = getInput();
		System.out.print("이름을 입력하세요 : ");
		String name = getInput();
		System.out.print("성별(F/M) : ");
		String gender = getInput();
		System.out.print("휴대폰번호를 입력하세요 : ");
		String phone = getInput();
		
		try {
			checkValidation(email, password, hint, name, gender,phone);
			
			Set<String> keys = map.keySet();
			for(String key : keys) {
				if(key.compareTo(email) == 0) {
					throw new Exception("이미 등록된 아이디가 있습니다.");
				}
			}
			
			System.out.println("=============================");
			System.out.println("∴ 회원가입이 완료되었습니다∴");
			String lastTime = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date());
			map.put(email, new User(email, password, hint, name, gender, phone
					, lastTime));
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(userFile), true));
			StringBuffer sb = new StringBuffer();
			sb.append(email).append(":");
			sb.append(password).append(":");
			sb.append(hint).append(":");
			sb.append(name).append(":");
			sb.append(gender).append(":");
			sb.append(phone).append(":");
			sb.append(lastTime).append("\n");
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			
		} catch (Exception e) {
			System.out.println("회원가입에 실패 하셨습니다.");
		}
	}
	
	private void checkValidation(String email, String password, String hint, String name, String gender
			,String phone) throws Exception {
		if(!name.matches("[가-힣]*$"))
			throw new Exception("이름은 한글로 입력하세요");
		if(!gender.matches("[mMfF]")) 
			throw new Exception("성별은 M/F 또는 m/f만 입력가능합니다.");
	}
	

	private void showMenu() {
		System.out.println("---------------------------------");
		System.out.println("⑴ 회원가입 ");
		System.out.println("⑵ 로그인");
		System.out.println("⑶ 비밀번호찾기");
		System.out.println("⑷ 종료");
		System.out.println("---------------------------------");
		System.out.print("원하시는 서비스 번호를 입력해주세요 : ");
	}
	
	private void exit() throws IOException {
		System.out.print("안전하게 로그아웃 되었습니다.");
		isExit = true;
		if (sc != null) {
			sc.close();
		}
	}
	
	private int getInputInt() {
		return Integer.parseInt(sc.nextLine());
	}
	
	private String getInput() {
		return sc.nextLine();
	}
}
