package kr.heartof.board.mybatis;

import java.util.List;

import kr.heartof.board.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> selectList();
	
	public void selectOne(int no);
	
	public int insert(BoardVO vo);
	
	public int delete(int no) ;
	
	public int update(BoardVO vo);
}
