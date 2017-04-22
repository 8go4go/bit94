package kr.co.mlec.board.mybatis;

import java.util.List;

import kr.co.mlec.board.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> selectList();
}
