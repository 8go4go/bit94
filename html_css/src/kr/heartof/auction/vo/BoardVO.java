package kr.heartof.auction.vo;

import java.util.Date;

public class BoardVO {
	private int BOARD_NUM    ;
	private String COMMENT_CON  ;
	private Date WRITE_DATE   ;
	private String EVAL         ;
	private String AUC_REG_NUM  ;
	private String AUC_TYPE_NUM ;
	private int USR_NUM      ;
	public int getBOARD_NUM() {
		return BOARD_NUM;
	}
	public void setBOARD_NUM(int bOARD_NUM) {
		BOARD_NUM = bOARD_NUM;
	}
	public String getCOMMENT_CON() {
		return COMMENT_CON;
	}
	public void setCOMMENT_CON(String cOMMENT_CON) {
		COMMENT_CON = cOMMENT_CON;
	}
	public Date getWRITE_DATE() {
		return WRITE_DATE;
	}
	public void setWRITE_DATE(Date wRITE_DATE) {
		WRITE_DATE = wRITE_DATE;
	}
	public String getEVAL() {
		return EVAL;
	}
	public void setEVAL(String eVAL) {
		EVAL = eVAL;
	}
	public String getAUC_REG_NUM() {
		return AUC_REG_NUM;
	}
	public void setAUC_REG_NUM(String aUC_REG_NUM) {
		AUC_REG_NUM = aUC_REG_NUM;
	}
	public String getAUC_TYPE_NUM() {
		return AUC_TYPE_NUM;
	}
	public void setAUC_TYPE_NUM(String aUC_TYPE_NUM) {
		AUC_TYPE_NUM = aUC_TYPE_NUM;
	}
	public int getUSR_NUM() {
		return USR_NUM;
	}
	public void setUSR_NUM(int uSR_NUM) {
		USR_NUM = uSR_NUM;
	}
}
