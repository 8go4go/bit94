package kr.heartof.auction.vo.member;

public class ComUsrVO extends UsrVO{
	private int USR_NUM     ;
	private String CHR_NM      ;
	private String COM_NM      ;
	private String 	BUS_REG_NUM ;
	private String CEO_NM      ;
	
	public int getUSR_NUM() {
		return USR_NUM;
	}
	public void setUSR_NUM(int uSR_NUM) {
		USR_NUM = uSR_NUM;
	}
	public String getCHR_NM() {
		return CHR_NM;
	}
	public void setCHR_NM(String cHR_NM) {
		CHR_NM = cHR_NM;
	}
	public String getCOM_NM() {
		return COM_NM;
	}
	public void setCOM_NM(String cOM_NM) {
		COM_NM = cOM_NM;
	}
	public String getBUS_REG_NUM() {
		return BUS_REG_NUM;
	}
	public void setBUS_REG_NUM(String bUS_REG_NUM) {
		BUS_REG_NUM = bUS_REG_NUM;
	}
	public String getCEO_NM() {
		return CEO_NM;
	}
	public void setCEO_NM(String cEO_NM) {
		CEO_NM = cEO_NM;
	}
}
