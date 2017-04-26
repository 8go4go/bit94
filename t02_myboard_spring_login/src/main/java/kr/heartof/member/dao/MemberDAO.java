package kr.heartof.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import kr.heartof.member.vo.LoginVO;

public class MemberDAO {
	private SqlSessionTemplate session;
	public void setSqlSessionTemplate(SqlSessionTemplate session) {
		this.session = session; 
	}
	
	public boolean login(String id, String password) {
		int result = session.selectOne("kr.heartof.member.mapper.MemberMapper.login", new LoginVO(id, password));
		
		return result == 1 ? true : false;
	}

}
