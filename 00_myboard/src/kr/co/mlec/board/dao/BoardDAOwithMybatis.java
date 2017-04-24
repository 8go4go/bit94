package kr.co.mlec.board.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.mlec.board.vo.BoardVO;

public class BoardDAOwithMybatis implements BoardDAOable {
	private String path = null;
	private SqlSessionFactory factory = null;

	public BoardDAOwithMybatis(String path) throws IOException {
		this.path = path;
		loadData();
	}

	@Override
	public void loadData() throws IOException {
		factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(path));
	}

	@Override
	public BoardVO[] selectList() {
		SqlSession session = null;
		List<BoardVO> result = null;
		try {
			session = factory.openSession(false);
			result = session.selectList("kr.co.mlec.board.mybatis.BoardMapper.selectList");
			session.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			session.close();
		}
		BoardVO[] vos = new BoardVO[result.size()];
		return result.toArray(vos);
	}

	@Override
	public BoardVO selectDetail(int num) {
		SqlSession session = factory.openSession(false);
		BoardVO vo = null;
		
		try {
			session = factory.openSession(false);
			vo = session.selectOne("kr.co.mlec.board.mybatis.BoardMapper.selectDetail", num);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			session.close();
		}
		
		return vo;
	}

	@Override
	public boolean insert(BoardVO insertData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		int result = 0;
		try {
			session = factory.openSession(false);
			result = session.insert("kr.co.mlec.board.mybatis.BoardMapper.insertBoard", insertData);
			session.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			session.close();
		}
		return result != 0 ? true : false;
	}

	@Override
	public boolean delete(int num) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		int result = 0;
		try {
			session = factory.openSession(false);
			result = session.delete("kr.co.mlec.board.mybatis.BoardMapper.deleteBoard", num);
			session.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			session.close();
		}
		
		return result != 0 ? true : false;
	}

	@Override
	public boolean update(int num, BoardVO updateData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		int result = 0;
		try {
			session = factory.openSession(false);
			result = session.update("kr.co.mlec.board.mybatis.BoardMapper.updateBoard", updateData);
			session.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			session.close();
		}
		
		return result != 0 ? true : false;
	}

}
