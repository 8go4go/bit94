package kr.heartof.auction.service.foruser.dao;

import java.util.List;

import kr.heartof.auction.vo.foruser.BoardVO;

public interface QnaDAO {
	public List<BoardVO> getBoardList() ;
	
	public boolean insertBoard(BoardVO vo);
	
	public boolean deleteBoard(int no);
	
	public boolean updateBoard(BoardVO vo);
	
	public int getBoardTotal();
}
