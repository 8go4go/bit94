package kr.heartof.member.mapper;

import kr.heartof.common.vo.FileVO;
import kr.heartof.member.vo.InterestVO;
import kr.heartof.member.vo.LoginVO;
import kr.heartof.member.vo.MemberInterestVO;
import kr.heartof.member.vo.MemberVO;
import kr.heartof.member.vo.ProfessionVO;
import kr.heartof.member.vo.StatusVO;
import kr.heartof.member.vo.ZipVO;

public interface MemberMapper {
	public int login(LoginVO vo);
	
	public void registerMember(MemberVO vo);
	
	public int registerMember_File(FileVO vo);
	
	public int registerMember_Status(StatusVO vo) ;
	
	public int registerMember_Interest(InterestVO vo);
	
	public int registerMember_Zip(ZipVO vo);
	
	public int registerMember_Profession(ProfessionVO vo);
	
	public int registerMember_MemInter(MemberInterestVO vo);
	
	public int maxMember();
	
	public int maxFile();
	
	public int maxProfession();
	
	public int maxZip();
	
	public int maxInterest();
	
	public int maxStatus();
}
