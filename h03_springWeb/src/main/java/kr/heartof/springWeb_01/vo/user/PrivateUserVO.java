package kr.heartof.springWeb_01.vo.user;

public class PrivateUserVO extends UserVO {
	private Integer USR_NO; //
	private String NM; // 
	private String SOCIAL_NO; // 앞자리

	public Integer getUSR_NO() {
		return USR_NO;
	}

	public void setUSR_NO(Integer uSR_NO) {
		USR_NO = uSR_NO;
	}

	public String getNM() {
		return NM;
	}

	public void setNM(String nM) {
		NM = nM;
	}

	public String getSOCIAL_NO() {
		return SOCIAL_NO;
	}

	public void setSOCIAL_NO(String sOCIAL_NO) {
		SOCIAL_NO = sOCIAL_NO;
	}
}
