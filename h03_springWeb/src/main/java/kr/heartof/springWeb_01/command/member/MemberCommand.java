package kr.heartof.springWeb_01.command.member;

import kr.heartof.springWeb_01.vo.user.UserVO;

public interface MemberCommand  {
	public UserVO isLogin(UserVO vo);

	public UserVO isLogin(String id, String passwd);
	
	public boolean joinMember(UserVO user)  throws Exception ;
}
