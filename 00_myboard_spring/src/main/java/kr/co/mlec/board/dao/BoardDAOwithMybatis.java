package kr.co.mlec.board.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import kr.co.mlec.board.vo.BoardVO;

public class BoardDAOwithMybatis  {
	private SqlSessionTemplate session;
	
	public BoardDAOwithMybatis() {}
	
	public void setSqlSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public void loadData() throws IOException {
	}

	public BoardVO[] selectList() {
		List<BoardVO> result = null;
		try {
			result = session.selectList("kr.co.mlec.board.mybatis.BoardMapper.selectList");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
		BoardVO[] vos = new BoardVO[result.size()];
		return result.toArray(vos);
	}

	public BoardVO selectDetail(int num) {
		BoardVO vo = null;
		
		try {
			vo = session.selectOne("kr.co.mlec.board.mybatis.BoardMapper.selectDetail", num);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
		
		return vo;
	}

	public boolean insert(BoardVO insertData) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = session.insert("kr.co.mlec.board.mybatis.BoardMapper.insertBoard", insertData);
			session.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
		return result != 0 ? true : false;
	}

	public boolean delete(int num) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = session.delete("kr.co.mlec.board.mybatis.BoardMapper.deleteBoard", num);
			session.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
		
		return result != 0 ? true : false;
	}

	public boolean update(int num, BoardVO updateData) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = session.update("kr.co.mlec.board.mybatis.BoardMapper.updateBoard", updateData);
			session.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
		
		return result != 0 ? true : false;
	}
}
