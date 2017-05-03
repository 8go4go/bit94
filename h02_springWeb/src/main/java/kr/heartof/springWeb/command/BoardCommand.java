package kr.heartof.springWeb.command;

import java.util.List;

import kr.heartof.springWeb.vo.BoardVO;

public interface BoardCommand {
	public List<BoardVO> list();
	
	public BoardVO detail(BoardVO vo);
	
	public boolean insert(BoardVO vo);
	
	public boolean modify(BoardVO vo);
	
	public boolean delete(BoardVO vo);
}
