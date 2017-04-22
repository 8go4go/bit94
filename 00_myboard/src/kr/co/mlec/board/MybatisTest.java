package kr.co.mlec.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.mlec.board.vo.BoardVO;

public class MybatisTest {
	final static String CONFIG_PATH = "kr/co/mlec/board/mybatis/mybatis_config.xml";
	public static void main(String[] args) throws IOException {
		SqlSessionFactory factory = 
				new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(CONFIG_PATH));
		
		SqlSession session = factory.openSession(false);
		
		List<BoardVO> list = session.selectList("kr.co.mlec.board.mybatis.BoardMapper.selectList");
		
		System.out.println(list.size());
		
		
		session.commit();
		session.close();
	}
}