package kr.heartof.auction.vo.member;

public class PrUsrVO extends UsrVO {
	private int USR_NUM         ;
	private String NM              ;
	private String SOCIAL_REG_NUM  ;
	
	public int getUSR_NUM() {
		return USR_NUM;
	}
	public void setUSR_NUM(int uSR_NUM) {
		USR_NUM = uSR_NUM;
	}
	public String getNM() {
		return NM;
	}
	public void setNM(String nM) {
		NM = nM;
	}
	public String getSOCIAL_REG_NUM() {
		return SOCIAL_REG_NUM;
	}
	public void setSOCIAL_REG_NUM(String sOCIAL_REG_NUM) {
		SOCIAL_REG_NUM = sOCIAL_REG_NUM;
	}
}
