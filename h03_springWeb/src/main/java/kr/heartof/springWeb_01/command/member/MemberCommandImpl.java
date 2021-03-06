package kr.heartof.springWeb_01.command.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.heartof.springWeb_01.member.dao.MemberDAO;
import kr.heartof.springWeb_01.vo.user.UserVO;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class MemberCommandImpl implements MemberCommand {
	private static final Logger logger = LoggerFactory.getLogger(MemberCommandImpl.class);

	@Autowired
	private MemberDAO dao;
 
	public UserVO isLogin(UserVO vo) {
		logger.info("isLogin");
		return dao.isLogin(vo);
	}

	public UserVO isLogin(String id, String passwd) {
		return dao.isLogin(id, passwd);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public boolean joinMember(UserVO user) throws Exception { 
		
		if(dao.joinMember(user)) {
			throw new RuntimeException("Transaction Test Error");
		} else {
			return false;
		}
	}
}
