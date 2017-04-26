package kr.heartof.board.ui;

import java.util.Scanner;

import kr.heartof.board.dao.BoardDAO;

public class BoardUI {
	private BoardDAO dao;
	
	private Scanner sc;
	
	public BoardUI() {
		sc = new Scanner(System.in);
		dao = new BoardDAO();
	}
	
	public void setBoardDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		while(true) {
			StringBuffer sb = new StringBuffer();
			sb.append("-----------------").append("\n");
			sb.append("1. 전체 게시물 조회").append("\n");
			sb.append("2. 글번호 조회").append("\n");
			sb.append("3. 글등록").append("\n");
			sb.append("4. 글수정").append("\n");
			sb.append("5. 글삭제").append("\n");
			sb.append("0. 종료").append("\n");
			sb.append("-----------------\n");
			sb.append("메뉴 중 처리할 항목을 선택하세요 : ");

			System.out.println(sb.toString());
			
			switch(getMenu()) {
			case 1:
				viewList();
				break;
			case 2:
				viewOne();
				break;
			case 3:
				insertView();
				break;
			case 4:
				updateView();
				break;
			case 5:
				deleteView();
				break;
			default :
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				System.exit(0);
				break;
			}
		}
	}
	
	private int getMenu() {
		System.out.println("원하시는 번호를 선택하세요");
		return Integer.parseInt(sc.nextLine());
	}
	
	private void viewList() {
		dao.selectList();
	}
	
	private void viewOne() {
		System.out.println("조회할 글번호를 입력하세요 : ");
		dao.selectOne(Integer.parseInt(sc.nextLine()));
	}
	
	private void deleteView() {
		System.out.println("삭제할 글번호를 입력하세요 : ");
		dao.delete(Integer.parseInt(sc.nextLine()));
	}
	
	private void insertView() {
		System.out.println("제목을 입력하세요 : ");
		String title = sc.nextLine();
		System.out.println("글쓴이를 입력하세요 : ");
		String content = sc.nextLine();
		System.out.println("내용을 입력하세요 : ");
		String writer = sc.nextLine();
		
		dao.insert(title, content, writer);
	}
	
	private void updateView() {
		System.out.println("수정할 글번호를 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("제목을 입력하세요 : ");
		String title = sc.nextLine();
		System.out.println("글쓴이를 입력하세요 : ");
		String content = sc.nextLine();
		System.out.println("내용을 입력하세요 : ");
		String writer = sc.nextLine();
		
		dao.update(num, title, content, writer);
	}
}
