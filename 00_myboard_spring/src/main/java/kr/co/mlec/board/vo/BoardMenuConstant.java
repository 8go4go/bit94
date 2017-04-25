package kr.co.mlec.board.vo;

public enum BoardMenuConstant {
	BOARD_LIST(1), BOARD_DETAIL(2), BOARD_INSERT(3), BOARD_UPDATE(4), BOARD_DELETE(5), BOARD_EXIT(0);

	private int index;

	BoardMenuConstant(int i) {
		this.index = i;
	}

	public int getIndex() {
		return index;
	}
	
	
	public static void main(String[] args) {
		System.out.println(BoardMenuConstant.BOARD_LIST.getIndex());
	}
	
	public BoardMenuConstant getIndex(int index) {
		if(BoardMenuConstant.BOARD_LIST.getIndex() == index) 
			return BOARD_LIST;
		else if(BoardMenuConstant.BOARD_DETAIL.getIndex() == index) 
			return BOARD_DETAIL;
		else if(BoardMenuConstant.BOARD_INSERT.getIndex() == index) 
			return BOARD_INSERT;
		else if(BoardMenuConstant.BOARD_UPDATE.getIndex() == index) 
			return BOARD_UPDATE;
		else if(BoardMenuConstant.BOARD_DELETE.getIndex() == index) 
			return BOARD_DELETE;
		else 
			return BOARD_DELETE;
	}
}
