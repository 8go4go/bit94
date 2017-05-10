package kr.heartof.springWeb_01.command.member;

import java.sql.SQLException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.heartof.springWeb_01.command.Command;
import kr.heartof.springWeb_01.vo.user.UserVO;

@Transactional(readOnly = false, rollbackFor = { Exception.class, SQLException.class }, propagation = Propagation.REQUIRED)
public interface MemberCommand extends Command {
	public UserVO isLogin(UserVO vo);

	public UserVO isLogin(String id, String passwd);
	
	public boolean joinMember(UserVO user)  throws Exception ;
}
