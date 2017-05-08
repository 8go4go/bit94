package kr.heartof.springWeb_01.command.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import kr.heartof.springWeb_01.command.Command;
import kr.heartof.springWeb_01.vo.user.UserVO;

public class MemberCommandImpl implements Command {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public boolean isLogin(UserVO vo) {
		int result = sqlSession.selectOne("kr.heartof.springWeb_01.sql.mybatis.LoginMapper.isLogin", vo);
		return result == 1 ? true : false;
	}
}
