package day15.exam;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MailService {
	private User user;
	boolean isMailExit = false;
	private Scanner sc = new Scanner(System.in);

	private ServiceUser service;

	public MailService(User user) throws IOException {
		this.user = user;
		service = new ServiceUser(user);
	}

	private int getInputInt() {
		return Integer.parseInt(sc.nextLine());
	}

	private String getInput() {
		return sc.nextLine();
	}

	public void mailService() throws IOException {
		System.out.printf("∴ %s님 환영합니다 ∴ \n", user.getName());
		System.out.printf("에 로그인 하셨습니다.", user.getLastLogTime());

		while (!isMailExit) {
			showMenu();
			int menu = getInputInt();
			switch (menu) {
			case 1:
				mailBox();
				break;
			case 2:
				sendMail();
				break;
			case 3:
				writeMail();
				break;
			case 4:
				trashCan();
				break;
			case 5:
				logout();
				break;
			}
			service.saveFile();
		}
	}

	private void mailBox() throws IOException {
		Map<Integer, Mail> mails = service.getRecMail();
		System.out.printf("%s님의 받은 메일 \n", user.getEmail());
		System.out.println("------------------------------------------");

		Set<Integer> keys = mails.keySet();

		for (Integer key : keys) {
			Mail m = mails.get(key);
			System.out.println("------------------------------------------");
			System.out.println("고유번호 :" + key);
			System.out.println("받는사람 주소 :" + m.getReciver());
			System.out.println("제목 :" + m.getTitle());
			System.out.println("내용 :" + m.getContent());
			System.out.println("받은 날짜 :" + m.getDate());
			System.out.println("------------------------------------------");
			m.setIsCheck("확인");
		}
		
		
		if(keys.size() > 0) {
			System.out.println("삭제할 이메일이 있습니까?(Y/N)");
			String yOrn = getInput();
			
			if(yOrn.equalsIgnoreCase("Y")) {
				System.out.println("삭제할 메일의 고유번호를 입력하세요");
				int removeIndex = getInputInt();
				keys = mails.keySet();
				
				if(keys.contains(removeIndex)) {
					service.transhMail("r", removeIndex);
					System.out.println("∴ 이메일이 삭제되었습니다 ∴");
				} else {
					System.out.println("∴ 이메일이 삭제가 실패되었습니다 ∴");
				}
			}
		} else {
			System.out.println("수신된 메일이 없습니다.");
		}
	}

	private void sendMail() throws IOException {
		Map<Integer, Mail> mails = service.getSendMail();
		System.out.printf("%s님의 보낸 메일 \n", user.getEmail());
		System.out.println("------------------------------------------");

		Set<Integer> keys = mails.keySet();

		for (Integer key : keys) {
			Mail m = mails.get(key);
			System.out.println("------------------------------------------");
			System.out.println("고유번호 :" + key);
			System.out.println("보내는사람 주소 :" + m.getSender());
			System.out.println("받는사람 주소 :" + m.getReciver());
			System.out.println("제목 :" + m.getTitle());
			System.out.println("내용 :" + m.getContent());
			System.out.println("받은 날짜 :" + m.getDate());
			System.out.println("------------------------------------------");
		}
		
		
		if(keys.size() > 0) {
			System.out.println("삭제할 이메일이 있습니까?(Y/N)");
			String yOrn = getInput();
			
			if(yOrn.equalsIgnoreCase("Y")) {
				System.out.println("삭제할 메일의 고유번호를 입력하세요");
				int removeIndex = getInputInt();
				keys = mails.keySet();
				
				if(keys.contains(removeIndex)) {
					service.transhMail("s", removeIndex);
					System.out.println("∴ 이메일이 삭제되었습니다 ∴");
				} else {
					System.out.println("∴ 이메일이 삭제가 실패되었습니다 ∴");
				}
			}
		} else {
			System.out.println("보낸편지가 없습니다.");
		}
	}

	private void writeMail() throws IOException {
		System.out.println("메일쓰기");
		System.out.println("메일쓰기를 선택하셨습니다.");
		System.out.print("수신자(메일받을사람)을 입력해주세요  : ");
		String reciver = getInput();
		System.out.println("제목을 입력하세요 : ");
		System.out.print("제목 :");
		String title = getInput();
		System.out.print("내용을 입력해주세요(2000자제한)내용:");
		String content = getInput();

		System.out.println("메일을 보내기가 완료되었습니다.");

		Mail mail = new Mail(++ServiceUser.MAILINDEX, user.getEmail(), reciver, title, content);
		service.sendMail(mail);
	}

	private void trashCan() throws IOException {
		Map<Integer, Mail> mails = service.getTrashMail();
		System.out.printf("휴지통 전체 확인을 선택 하셨습니다.");
		System.out.println("------------------------------------------");
		System.out.println("고유번호\t확인여부\t보낸사람\t시간\t제목");
		Set<Integer> keys = mails.keySet();

		for (Integer key : keys) {
			Mail m = mails.get(key);
			System.out.printf("%d\t%s\t%s\t%s\t%s\t\n", m.getNum(), m.getIsCheck(), m.getSender(), m.getDate(), m.getTitle());
		}
		boolean isExit = false;
		while (!isExit) {
			showMenuSub();
			int menu = getInputInt();
			switch (menu) {
			case 1:
				isExit = true;
				break;
			case 2:
				System.out.printf("영구 삭제 할 이메일 고유번호를 선택 하세요");
				Integer removeIndex = getInputInt();
				keys = mails.keySet();
				
				if(keys.contains(removeIndex)) {
					service.transhMail("t", removeIndex);
					System.out.println("∴ 이메일이 삭제되었습니다 ∴");
				} else {
					System.out.println("∴ 이메일이 삭제가 실패되었습니다 ∴");
				}
				break;
			}
		}
	}
	
	private void showMenuSub() {
		System.out.println("---------------------------------");
		System.out.println("1.받은편지함으로 이동");
		System.out.println("2.영구삭제");
		System.out.println("---------------------------------");
		System.out.print("원하시는 서비스 번호를 입력해주세요 : ");
	}
	
	private void logout() {
		System.out.print("안전하게 로그아웃 되었습니다.");
		isMailExit = true;
	}

	private void showMenu() {
		System.out.println("---------------------------------");
		System.out.println("1. 받은메일함");
		System.out.println("2. 보낸메일함");
		System.out.println("3. 메일쓰기");
		System.out.println("4. 휴지통");
		System.out.println("5. 로그아웃");
		System.out.println("---------------------------------");
		System.out.print("원하시는 서비스 번호를 입력해주세요 : ");
	}
}