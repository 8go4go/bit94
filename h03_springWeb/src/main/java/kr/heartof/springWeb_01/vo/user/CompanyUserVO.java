package kr.heartof.springWeb_01.vo.user;

public class CompanyUserVO extends UserVO {
	private Integer USR_NO;
	private String COM_NM;
	private String BUS_NO;
	private String CEO_NM;
	private String CHG_NM;

	public Integer getUSR_NO() {
		return USR_NO;
	}

	public void setUSR_NO(Integer uSR_NO) {
		USR_NO = uSR_NO;
	}

	public String getCOM_NM() {
		return COM_NM;
	}

	public void setCOM_NM(String cOM_NM) {
		COM_NM = cOM_NM;
	}

	public String getBUS_NO() {
		return BUS_NO;
	}

	public void setBUS_NO(String bUS_NO) {
		BUS_NO = bUS_NO;
	}

	public String getCEO_NM() {
		return CEO_NM;
	}

	public void setCEO_NM(String cEO_NM) {
		CEO_NM = cEO_NM;
	}

	public String getCHG_NM() {
		return CHG_NM;
	}

	public void setCHG_NM(String cHG_NM) {
		CHG_NM = cHG_NM;
	}

}
