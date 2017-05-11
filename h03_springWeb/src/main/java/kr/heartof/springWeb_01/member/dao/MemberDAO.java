package kr.heartof.springWeb_01.member.dao;

import kr.heartof.springWeb_01.vo.user.UserVO;

public interface MemberDAO {
	public UserVO isLogin(UserVO vo);

	public UserVO isLogin(String id, String passwd);
	
	public boolean joinMember(UserVO user)  throws Exception ;
}
