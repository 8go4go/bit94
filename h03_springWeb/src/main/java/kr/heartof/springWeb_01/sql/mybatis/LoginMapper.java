package kr.heartof.springWeb_01.sql.mybatis;

import kr.heartof.springWeb_01.vo.user.UserVO;

public interface LoginMapper {
	public boolean isLogin(UserVO user);
}