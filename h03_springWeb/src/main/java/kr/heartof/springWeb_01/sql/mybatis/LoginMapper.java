package kr.heartof.springWeb_01.sql.mybatis;

import kr.heartof.springWeb_01.vo.user.UserVO;

public interface LoginMapper {
	public int isLogin(UserVO user);
	
	public int joinUser(UserVO user);
	
	public int joinCompanyUser(UserVO user);
	
	public int joinPrivateUser(UserVO user);
}
