package kr.heartof.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.heartof.member.vo.InterestVO;
import kr.heartof.member.vo.LoginVO;
import kr.heartof.member.vo.MemberInterestVO;
import kr.heartof.member.vo.MemberVO;
import kr.heartof.member.vo.ProfessionVO;
import kr.heartof.member.vo.StatusVO;
import kr.heartof.member.vo.ZipVO;

public class MemberDAO {
	private SqlSessionTemplate session;
	public void setSqlSessionTemplate(SqlSessionTemplate session) {
		this.session = session; 
	}
	
	public boolean login(String id, String password) {
		int result = session.selectOne("kr.heartof.member.mapper.MemberMapper.login", new LoginVO(id, password));
		
		return result == 1 ? true : false;
	}
	
	public String findId(String email, String phone) {
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setPhone(phone);
		String result = session.selectOne("kr.heartof.member.mapper.MemberMapper.findId", vo);
		
		return result;
	}
	
	public String findPass(String id, String email, String phone) {
		MemberVO vo = new MemberVO();
		vo.setUserid(id);
		vo.setEmail(email);
		vo.setPhone(phone);
		String result = session.selectOne("kr.heartof.member.mapper.MemberMapper.findPass", vo);
		
		return result;
	}
	
	public int registerMember(MemberVO vo, MemberInterestVO miv) {
		
		int result = session.insert("kr.heartof.member.mapper.MemberMapper.registerMember", vo);
		session.insert("kr.heartof.member.mapper.MemberMapper.registerMember_MemInter", miv);
		
		return result;
	}

	public List<ZipVO> selectZip() {
		return session.selectList("kr.heartof.member.mapper.MemberMapper.zip");
	}
	
	public List<ProfessionVO> selectProfession() {
		return session.selectList("kr.heartof.member.mapper.MemberMapper.profession");
	}
	
	public List<InterestVO> selectInterest() {
		return session.selectList("kr.heartof.member.mapper.MemberMapper.interest");
	}
	
	public List<StatusVO> selectStatus() {
		return session.selectList("kr.heartof.member.mapper.MemberMapper.status");
	}
	
	public int getMaxMember() {
		return session.selectOne("kr.heartof.member.mapper.MemberMapper.maxMember");
	}
}
