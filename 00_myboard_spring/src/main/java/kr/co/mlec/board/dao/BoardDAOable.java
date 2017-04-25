package kr.co.mlec.board.dao;

import java.io.IOException;

import kr.co.mlec.board.vo.BoardVO;

public interface BoardDAOable {
	public void loadData() throws IOException;
	
	public BoardVO[] selectList();
	
	public BoardVO selectDetail(int num);
	
	public boolean insert(BoardVO insertData);
	
	public boolean delete(int num);
	
	public boolean update(int num, BoardVO updateData);
}
