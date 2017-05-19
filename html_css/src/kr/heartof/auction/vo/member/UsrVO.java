package kr.heartof.auction.vo.member;

import java.util.Date;

public class UsrVO {
	private int USR_NUM       ;
	private String EMAIL         ;
	private String SEC_NUM       ;
	private String ZIP_NUM       ;
	private String ADDRESS       ;
	private String TELNO         ;
	private String MOB_NUM       ;
	private Date REG_DATE      ;
	private String USR_CD        ;
	private String CRE_DEG_STAT  ;
	
	public int getUSR_NUM() {
		return USR_NUM;
	}
	public void setUSR_NUM(int uSR_NUM) {
		USR_NUM = uSR_NUM;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getSEC_NUM() {
		return SEC_NUM;
	}
	public void setSEC_NUM(String sEC_NUM) {
		SEC_NUM = sEC_NUM;
	}
	public String getZIP_NUM() {
		return ZIP_NUM;
	}
	public void setZIP_NUM(String zIP_NUM) {
		ZIP_NUM = zIP_NUM;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getTELNO() {
		return TELNO;
	}
	public void setTELNO(String tELNO) {
		TELNO = tELNO;
	}
	public String getMOB_NUM() {
		return MOB_NUM;
	}
	public void setMOB_NUM(String mOB_NUM) {
		MOB_NUM = mOB_NUM;
	}
	public Date getREG_DATE() {
		return REG_DATE;
	}
	public void setREG_DATE(Date rEG_DATE) {
		REG_DATE = rEG_DATE;
	}
	public String getUSR_CD() {
		return USR_CD;
	}
	public void setUSR_CD(String uSR_CD) {
		USR_CD = uSR_CD;
	}
	public String getCRE_DEG_STAT() {
		return CRE_DEG_STAT;
	}
	public void setCRE_DEG_STAT(String cRE_DEG_STAT) {
		CRE_DEG_STAT = cRE_DEG_STAT;
	}
}
