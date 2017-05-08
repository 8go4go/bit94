package kr.heartof.springWeb_01.vo.user;

import java.util.Date;

public class UserVO {
	private int USR_NO	;
	private String USRID   ;
	private String PASSWD   ;
	private String EMAIL   ;
	private String TELNO   ;
	private String ZIPNO   ;
	private String ADDRESS ;
	private Date REG_DATE  ;
	private String USR_CD  ;
	private String CRE_DEG_CD ;
	/**
	 * @return the uSR_NO
	 */
	int getUSR_NO() {
		return USR_NO;
	}
	/**
	 * @param uSR_NO the uSR_NO to set
	 */
	void setUSR_NO(int uSR_NO) {
		USR_NO = uSR_NO;
	}
	/**
	 * @return the uSRID
	 */
	String getUSRID() {
		return USRID;
	}
	/**
	 * @param uSRID the uSRID to set
	 */
	void setUSRID(String uSRID) {
		USRID = uSRID;
	}
	/**
	 * @return the eMAIL
	 */
	
	String getEMAIL() {
		return EMAIL;
	}
	/**
	 * @return the pASSWD
	 */
	String getPASSWD() {
		return PASSWD;
	}
	/**
	 * @param pASSWD the pASSWD to set
	 */
	void setPASSWD(String pASSWD) {
		PASSWD = pASSWD;
	}
	/**
	 * @param eMAIL the eMAIL to set
	 */
	void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	/**
	 * @return the tELNO
	 */
	String getTELNO() {
		return TELNO;
	}
	/**
	 * @param tELNO the tELNO to set
	 */
	void setTELNO(String tELNO) {
		TELNO = tELNO;
	}
	/**
	 * @return the zIPNO
	 */
	String getZIPNO() {
		return ZIPNO;
	}
	/**
	 * @param zIPNO the zIPNO to set
	 */
	void setZIPNO(String zIPNO) {
		ZIPNO = zIPNO;
	}
	/**
	 * @return the aDDRESS
	 */
	String getADDRESS() {
		return ADDRESS;
	}
	/**
	 * @param aDDRESS the aDDRESS to set
	 */
	void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	/**
	 * @return the rEG_DATE
	 */
	Date getREG_DATE() {
		return REG_DATE;
	}
	/**
	 * @param rEG_DATE the rEG_DATE to set
	 */
	void setREG_DATE(Date rEG_DATE) {
		REG_DATE = rEG_DATE;
	}
	/**
	 * @return the uSR_CD
	 */
	String getUSR_CD() {
		return USR_CD;
	}
	/**
	 * @param uSR_CD the uSR_CD to set
	 */
	void setUSR_CD(String uSR_CD) {
		USR_CD = uSR_CD;
	}
	/**
	 * @return the cRE_DEG_CD
	 */
	String getCRE_DEG_CD() {
		return CRE_DEG_CD;
	}
	/**
	 * @param cRE_DEG_CD the cRE_DEG_CD to set
	 */
	void setCRE_DEG_CD(String cRE_DEG_CD) {
		CRE_DEG_CD = cRE_DEG_CD;
	}
	
	
}
