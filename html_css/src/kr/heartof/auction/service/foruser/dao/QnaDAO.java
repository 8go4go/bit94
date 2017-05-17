package kr.heartof.auction.service.foruser.dao;

import java.util.List;

import kr.heartof.auction.service.dao.BoardDAO;
import kr.heartof.auction.vo.BoardVO;

public interface QnaDAO extends BoardDAO{
	public List<BoardVO> getBoardList(int currentPage, int viewCount);
	
	public boolean insertBoard(BoardVO vo);
	
	public boolean deleteBoard(int no);
	
	public boolean updateBoard(BoardVO vo);
	
	public int getBoardTotal();
}
