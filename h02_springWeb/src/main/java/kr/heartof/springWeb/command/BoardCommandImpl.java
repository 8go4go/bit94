package kr.heartof.springWeb.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.heartof.springWeb.dao.BoardDAO;
import kr.heartof.springWeb.vo.BoardVO;

public class BoardCommandImpl implements BoardCommand {
	private BoardDAO dao;
	
	public void setBoardDAO(BoardDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<BoardVO> list() {
		return dao.list();
	}

	@Override
	public BoardVO detail(BoardVO vo) {
		return dao.detail(vo);
	}

	@Override
	public boolean insert(BoardVO vo) {
		return dao.insert(vo);
	}

	@Override
	public boolean modify(BoardVO vo) {
		return dao.modify(vo);
	}

	@Override
	public boolean delete(BoardVO vo) {
		return dao.delete(vo);
	}
}
