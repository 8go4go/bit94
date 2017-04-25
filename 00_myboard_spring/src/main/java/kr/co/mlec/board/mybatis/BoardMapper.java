package kr.co.mlec.board.mybatis;

import java.util.List;

import kr.co.mlec.board.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> selectList();
	
	public BoardVO selectDetail(int no);
	
	public int deleteBoard(int no);
	
	public int insertBoard(BoardVO insertData);
	
	public int updateBoard(BoardVO updateData);
}
