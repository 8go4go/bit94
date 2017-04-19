package kr.co.mlec.board.vo;

public enum BoardErrorType {
	MENU_WRONG (1, "메뉴 선택은 숫자만 가능합니다. 다시 선택 바랍니다."),
	NO_DATA (2, "해당하는 게시글이 존재하지 않습니다.");
	
	private final int index;
	private final String msg;
	BoardErrorType(int i, String msg) {
		this.index = i;
		this.msg = msg;
	}
	
	public int index() {
		return this.index;
	}
	
	public String getMsg() {
		return this.msg; 
	}
}
