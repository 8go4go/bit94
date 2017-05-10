package kr.heartof.springWeb_01.command.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.heartof.springWeb_01.command.Command;
import kr.heartof.springWeb_01.constant.EnumUsrCD;
import kr.heartof.springWeb_01.vo.user.CompanyUserVO;
import kr.heartof.springWeb_01.vo.user.PrivateUserVO;
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
		user.setUSRID(user.getEMAIL().substring(0, user.getEMAIL().indexOf("@")));
		result = sqlSession.insert("kr.heartof.springWeb_01.sql.mybatis.LoginMapper.joinUser", user);
		
		logger.info("joinMember : " + user.getUSR_CD());
		
		if(user.getUSR_CD().equals(EnumUsrCD.PRIVATE_USER.getKey())) {
			PrivateUserVO pvo = (PrivateUserVO)user;
			result = result + sqlSession.insert("kr.heartof.springWeb_01.sql.mybatis.LoginMapper.joinPrivateUser", pvo);
		} else {
			CompanyUserVO cvo = (CompanyUserVO)user;
			result = result + sqlSession.insert("kr.heartof.springWeb_01.sql.mybatis.LoginMapper.joinCompanyUser", cvo);
		}
		return result == 2;
	}
}
