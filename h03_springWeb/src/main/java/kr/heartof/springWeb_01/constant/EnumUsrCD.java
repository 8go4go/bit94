package kr.heartof.springWeb_01.constant;

public enum EnumUsrCD {
//	 1. 개인회원
//	 2. 기업회원
	PRIVATE_USER("1", "기업회원"), 
	COMPANY_USER("2", "개인회원");
	private String value;
	private String key;
	
	EnumUsrCD(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
