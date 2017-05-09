package kr.heartof.springWeb_01.command.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.heartof.springWeb_01.command.Command;
import kr.heartof.springWeb_01.constant.EnumUsrCD;
import kr.heartof.springWeb_01.vo.user.UserVO;

@Repository
public class MemberCommandImpl implements Command {
	private static final Logger logger = LoggerFactory.getLogger(MemberCommandImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
//	public void setSqlSession(SqlSessionTemplate sqlSession) {
//		this.sqlSession = sqlSession;
//	}
	
	public UserVO isLogin(UserVO vo) {
		logger.info("isLogin");
		UserVO user = sqlSession.selectOne("kr.heartof.springWeb_01.sql.mybatis.LoginMapper.isLogin", vo);
		return user;
	}
	
	public UserVO isLogin(String id, String passwd) {
		UserVO vo = new UserVO();
		vo.setUSRID(id);
		vo.setPASSWD(passwd);
		return isLogin(vo);
	}
	
	public boolean joinMember(UserVO user) {
		int result = 0;
		result = sqlSession.insert("kr.heartof.springWeb_01.sql.mybatis.LoginMapper.joinUser", user);
		if(EnumUsrCD.valueOf(user.getUSR_CD()) == EnumUsrCD.PRIVATE_USER) {
			result = result + sqlSession.insert("kr.heartof.springWeb_01.sql.mybatis.LoginMapper.joinCompanyUser", user);
		} else {
			result = result + sqlSession.insert("kr.heartof.springWeb_01.sql.mybatis.LoginMapper.joinPrivateUser", user);
		}
		return result == 2;
	}
}
