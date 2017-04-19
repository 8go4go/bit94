package kr.co.mlec.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class BoardTestWithConnectedDB {
	protected static final int MENU_LIST = 1;
	protected static final int MENU_READ = 2;
	protected static final int MENU_WRITE = 3;
	protected static final int MENU_MODIFIED = 4;
	protected static final int MENU_DELETE = 5;
	protected static final int MENU_EXIT = 0;

	private Scanner sc = null;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Loaded Database Driver");

		BoardTestWithConnectedDB b = new BoardTestWithConnectedDB();

		Connection con = b.getConnection("lee", "1234", "jdbc:mysql://192.168.0.149:3306/board");

		if (con == null)
			throw new SQLException("failed connecting to mysql");

		b.makeProcess(con);

		b.terminateConnection(con);
	}

	private BoardTestWithConnectedDB() {
		sc = new Scanner(System.in);
	}

	private void makeProcess(Connection con) throws SQLException {
		System.out.println("started makeProcess");
		while (true) {
			String selectedMenu = null;
			printHeader();
			int menu = getIntFromKeyBoard("메뉴 중 처리할 항목을 선택하세요 : ");

			switch (menu) {
			case MENU_LIST:
				printList_1(con);
				selectedMenu = "전체 게시글 조회";
				break;
			case MENU_READ:
				printRead_2(con, getIntFromKeyBoard("조회할 글 번호를 입력하세요 : "));
				selectedMenu = "글 번호 조회";
				break;
			case MENU_WRITE:
				printWrite_3(con);
				selectedMenu = "글 등록";
				break;
			case MENU_MODIFIED:
				selectedMenu = "글 수정";
				break;
			case MENU_DELETE:
				selectedMenu = "글 삭제";
				break;
			case MENU_EXIT:
				selectedMenu = "게시판 프로그램을 종료합니다.";
				break;
			default:
				System.err.println("없는 메뉴입니다.");
				break;
			}

			if (selectedMenu != null) {
				printTail(selectedMenu);
				if (menu == MENU_EXIT) {
					con.close();
					System.exit(0);
				}
			}
		}
	}
	private int getBoardNum(Connection con) throws SQLException {
		ResultSet rs = con.createStatement()
				.executeQuery("select max(boardnum)  from board");
		int boardNum = 0;
		while (rs.next()) {
			boardNum = rs.getInt(1) + 1;
		}
		rs.close();
		
		return boardNum;
	}
	private void printWrite_3(Connection con) throws SQLException {
		int boardNum = getBoardNum(con);
		System.out.print("제목을 입력하세요 : ");
		String title = sc.nextLine();
		System.out.print("\n내용을 입력하세요 : ");
		String content = sc.nextLine();
		System.out.print("\n글쓴이를 입력하세요 : ");
		String author = sc.nextLine();
		
		PreparedStatement pre = con.prepareStatement("insert into board (boardNum, title, content, email) values (?,?,?,?)");
		pre.setInt(1, boardNum);
		pre.setString(2, title);
		pre.setString(3, content);
		pre.setString(4, author);
		
		if(!pre.execute())
			System.out.println("글을 등록 할수 없습니다.");
	}

	private void printRead_2(Connection con, int boardNum) throws SQLException {
		PreparedStatement pre = con.prepareStatement("select boardnum, title, content, email from board where boardnum = ? ");
		pre.setInt(1, boardNum);
		
		ResultSet rs = pre.executeQuery();
		
		Vector<String> vec = new Vector<String>();
		while (rs.next()) {
			vec.add(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3));
		}
		
		int i=0;
		for(String content : vec) {
			i++;
			System.out.println(content);
		}
		
		if(i == 0)
			System.out.println("입력된 번호는 존재하지 않습니다.");
		
		rs.close();
	}
	
	private void printList_1(Connection con) throws SQLException {
		printBoardTitle();

		ResultSet rs = con.createStatement()
				.executeQuery("select boardnum, title, email  from board order by boardnum asc");
		
		Vector<String> vec = new Vector<String>();
		
		while (rs.next()) {
			vec.add(rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3));
		}
		
		int i=0;
		for(String content : vec) {
			i++;
			System.out.println(content);
		}
		
		if(i == 0)
			System.out.println("입력된 번호는 존재하지 않습니다.");
		
		rs.close();
	}

	private String getStringFromKeyBoard() {
		return sc.nextLine();
	}

	private int getIntFromKeyBoard(String msg) {
		if (msg != null)
			System.out.print(msg);

		int menu = -1;

		try {
			menu = sc.nextInt();
		} catch (Exception e) {
			System.err.println("숫자만 입력해주세요 ");
		}

		return menu;
	}

	private void printHeader() {
		System.out.println("------------------------------------");
		System.out.println("1. 전체 게시물 조회");
		System.out.println("2. 글 번호 조회");
		System.out.println("3. 글 등록");
		System.out.println("4. 글 수정");
		System.out.println("5. 글 삭제");
		System.out.println("0. 종료");
		System.out.println("------------------------------------");
	}

	private void printTail(String msg) {
		System.out.println("[" + msg + " 메뉴 선택함]");
		System.out.println();
		System.out.println();
		System.out.println();
	}

	private void printBoardTitle() {
		System.out.println("-------------------------------");
		System.out.println("번호\t  제목\t\t  글쓴이");
		System.out.println("-------------------------------");
	}

	public Connection getConnection(String user, String pass, String url) throws SQLException {
		Connection con = DriverManager.getConnection(url, user, pass);
		System.out.println("got the Connection");
		return con;
	}

	public void terminateConnection(Connection con) throws SQLException {
		con.close();
		System.out.println("closed the Connection");
	}
}
