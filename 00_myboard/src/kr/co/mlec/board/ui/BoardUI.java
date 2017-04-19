package kr.co.mlec.board.ui;

import java.io.IOException;
import java.util.Scanner;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardErrorType;
import kr.co.mlec.board.vo.BoardMenuConstant;
import kr.co.mlec.board.vo.BoardVO;

public class BoardUI {
	private boolean isRunning = false;

	private BoardDAO dao;

	private Scanner keyInput;

	public BoardUI() {
		try {
			dao = new BoardDAO("ioload/day08/load.txt", 5);
		} catch (IOException e) {
			System.out.println(showError(BoardErrorType.INIT_LOAD_ERR));
		}
		keyInput = new Scanner(System.in);
	}

	public void service() {
		run();
	}
	
	public void run() {
		BoardMenuConstant menu = null;
		Scanner keyInput = new Scanner(System.in);
		while (!isRunning) {
			showWelcome();
			try {
				menu = getMenu();
			} catch (Exception e) {
				System.out.println(showError(BoardErrorType.MENU_WRONG));
				continue;
			}

			switch (menu) {
			case BOARD_LIST:
				showBoardList();
				break;
			case BOARD_DETAIL:
				showBoardDetail();
				break;
			case BOARD_INSERT:
				processInsert();
				break;
			case BOARD_UPDATE:
				processUpdate();
				break;
			case BOARD_DELETE:
				processDelete();
				break;
			case BOARD_EXIT:
				stopApplication();
				break;
			default:
				System.out.println(showError(BoardErrorType.MENU_WRONG));
				break;
			}
		}
		keyInput.close();
	}

	private void stopApplication() {
		showResult("프로그램을 종료합니다.");
		keyInput.close();
		System.exit(0);
	}

	private void showBoardList() {
		showResult("---------------------------");
		showResult("번호\t제목\t글쓴이");
		showResult("---------------------------");
		BoardVO[] datas = dao.getDatas();

		if (datas != null) {
			for (int i = datas.length - 1; i >= 0; i--) {
				showRows(datas[i]);
			}
		} else {
			showResult("게시물이 존재하지 않습니다.");
		}
	}

	private void showBoardDetail() {
		showResult("조회할 글번호를 입력하세요 : ");
		int no = getDataInt();
		showResult("---------------------------");
		BoardVO data = dao.selectDetail(no);
		if (data != null)
			showRow(data);
		else
			showResult(BoardErrorType.NO_DATA.getMsg());

	}

	private void processInsert() {
		BoardVO insertData = new BoardVO();

		showResult("제목을 입력하세요 : ");
		insertData.setTitle(getData());
		showResult("글쓴이를 입력하세요 : ");
		insertData.setWriter(getData());
		showResult("내용을 입력하세요 : ");
		insertData.setContent(getData());

		boolean isResult = dao.insertWithFile(insertData);

		String result = isResult ? "글등록이 완료 되었습니다." : "글등록이 실패하였습니다.";
		showResult(result);
	}

	private void processUpdate() {
		showResult("수정할 글번호를 입력하세요 : ");
		int no = getDataInt();

		BoardVO updateData = new BoardVO();

		showResult("변경할 제목을 입력하세요 : ");
		updateData.setTitle(getData());
		showResult("변경할 내용을 입력하세요 : ");
		updateData.setContent(getData());

		boolean isResult = dao.update(no, updateData);

		String result = isResult ? "글수정이 완료 되었습니다." : "글수정이 실패하였습니다.";
		showResult(result);
	}

	private void processDelete() {
		showResult("삭제할 글번호를 입력하세요 : ");
		int no = getDataInt();
		boolean isResult = dao.delete(no);

		String result = isResult ? "글삭제가 완료 되었습니다." : "글삭제가 실패하였습니다.";
		showResult(result);
	}

	private BoardMenuConstant getMenu() throws Exception {

		BoardMenuConstant menu = null;
		try {
			menu = BoardMenuConstant.BOARD_LIST.getIndex(Integer.parseInt(keyInput.nextLine()));

		} catch (Exception e) {
			keyInput.close();
			throw new Exception("It's not invalid data, check input type number, you should input int data type.");
		}

		return menu;
	}

	private String getData() {
		String str = keyInput.nextLine();
		return str;
	}

	private int getDataInt() {
		int iNum = Integer.parseInt(keyInput.nextLine());
		return iNum;
	}

	private void showWelcome() {
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
	}

	private void showResult(String resultStr) {
		System.out.println(resultStr);
	}

	private String showError(BoardErrorType error) {
		switch (error) {
		case NO_DATA:
			return error.getMsg();
		case MENU_WRONG:
			return error.getMsg();
		case INIT_LOAD_ERR :
			return error.getMsg();
		default:
			return null;
		}
	}

	private void showRows(BoardVO vo) {
		System.out.printf("%d\t%s\t%s\n", vo.getNo(), vo.getTitle(), vo.getWriter());
	}

	private void showRow(BoardVO vo) {
		System.out.println("번호 : " + vo.getNo());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("글쓴이 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
	}
}
