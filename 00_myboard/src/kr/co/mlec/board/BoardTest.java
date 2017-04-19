package kr.co.mlec.board;

import java.util.Scanner;

public class BoardTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu = 1;
		String selectMenu = "";
		
		int storyNum;
		String title;
		String author;
		
		String[][] board = null; // 게시판의 행을 나타내는 배열
		
		while(menu != 0) {
			System.out.println("------------------------------------");
			System.out.println("1. 전체 게시물 조회");
			System.out.println("2. 글 번호 조회");
			System.out.println("3. 글 등록");
			System.out.println("4. 글 수정");
			System.out.println("5. 글 삭제");
			System.out.println("0. 종료");
			System.out.println("------------------------------------");
			
			System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
			menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
				case 1:
					selectMenu = "전체 게시글 조회";
					print_1(board);
					break;
				case 2:					
					System.out.print("조회할 글 번호를 입력하세요 : ");
					storyNum = Integer.parseInt(sc.nextLine());
					if(board != null) {
						print_2(board[storyNum - 1]);
					} else {
						System.out.println("입력된 번호는 존재하지 않습니다.");
					}
					
					selectMenu = "글 번호 조회";
					break;
				case 3:
					System.out.print("제목을 입력하세요 : ");
					title = sc.nextLine();
					System.out.print("글쓴이를 입력하세요 : ");
					author = sc.nextLine();
					
					String[] content = {String.valueOf(board == null? 1 : board.length + 1), title, author}; // 게시판의 한 행에 들어갈 컨텐츠 (번호, 글쓴이, 제목)
					
					board = print_3(board, content);
					selectMenu = "글 등록";
					break;
				case 4:
					System.out.print("수정할 글 번호를 입력하세요 : ");
					storyNum = Integer.parseInt(sc.nextLine());
					
					if(board == null || storyNum - 1 == board.length) {
						System.out.println("입력된 번호는 존재하지 않습니다.");
					} else {
						System.out.print("변경할 제목을 입력하세요 : ");
						title = sc.nextLine();
						
						print_4(board, title, storyNum - 1);
					}
					selectMenu = "글 수정";
					
					break;
				case 5:
					System.out.print("삭제할 글 번호를 입력하세요 : ");
					storyNum = Integer.parseInt(sc.nextLine());
					if(board == null || storyNum - 1 == board.length) {
						System.out.println("입력된 번호는 존재하지 않습니다.");
					} else {
						board = print_5(board, storyNum - 1);
					}
					selectMenu = "글 삭제";
					break;
				case 0:
					System.out.println("게시판 프로그램을 종료합니다.");
					break;
				default:
					System.out.println("\n**메뉴를 다시 선택해 주세요.**\n");
			}
			
			if(menu >= 1 && menu <= 5)
				System.out.println(selectMenu + " 메뉴 선택함");
		}
	}
	
	private static String[][] print_5(String[][] board, int index) {
		if(index > board.length - 1) {
			System.out.println("입력하신 번호에 해당하는 게시글이 없습니다.");
			return board;
		}
		
		if(board.length == 1) {
			System.out.println("게시글이 삭제되었습니다.");
			return null;
		}
		
		String[][] newBoard = new String[board.length - 1][];
		
		if(index == 0) {
			System.arraycopy(board, index + 1, newBoard, 0, newBoard.length);
		} else if(index == board.length - 1) {
			System.arraycopy(board, 0, newBoard, 0, newBoard.length);
		} else {
			System.arraycopy(board, index - 1, newBoard, 0, index);
			System.arraycopy(board, index + 1, newBoard, index, newBoard.length - index);
		}
		
		for(int i=0; i < newBoard.length; i++) {
			newBoard[i][0] = String.valueOf(i + 1);
		}
		
		System.out.println("게시글이 삭제되었습니다.");
		
		return newBoard;
	}
	
	
	private static void print_4(String[][] board, String title, int index) {
		if(board == null || index == board.length) {
			System.out.println("입력된 번호는 존재하지 않습니다.");
			return;
		}
		
		
		board[index][1] = title;
		System.out.println("게시글이 수정되었습니다.");
	}
	
	private static String[][] print_3(String[][] board, String[] content) {
		String[][] newBoard = null;
		if(board == null) {
			board = new String[1][];
			board[0] = content;
			System.out.println("게시글 등록이 완료되었습니다.");
			return board;
		} else {
			newBoard = new String[board.length + 1][];
			System.arraycopy(board, 0, newBoard, 0, board.length);
			newBoard[board.length] = content;
			System.out.println("게시글 등록이 완료되었습니다.");
			return newBoard;
		}
	}

	private static void print_2(String[] content) {
		System.out.println("-------------------------------");
		System.out.println("번호\t 글쓴이 \t제목");
		System.out.println("-------------------------------");
		
		if(content == null) {
			System.out.println("입력된 번호는 존재하지 않습니다.");
		} else {
			System.out.printf(" 번호 : %s\n", content[0]);
			System.out.printf(" 글쓴이 : %s\n", content[1]);
			System.out.printf(" 제목 : %s\n", content[2]);
		}
		System.out.println("-------------------------------");
	}
	
	private static void print_1(String[][] board) {
		System.out.println("-------------------------------");
		System.out.println("번호\t 글쓴이 \t제목");
		System.out.println("-------------------------------");
		
		if(board == null) {
			System.out.println("게시물이 존재하지 않습니다.");
		} else {
			System.out.printf("전체 %d 개\n", board.length);
			for(int i=board.length - 1; i > -1; i--) {
				String[] content = board[i];
				for(String value : content) {
					System.out.printf(" %s\t", value);
				}
				System.out.println("");
			}
		}
		System.out.println("-------------------------------");
	}
}