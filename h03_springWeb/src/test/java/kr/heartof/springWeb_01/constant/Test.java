package kr.heartof.springWeb_01.constant;

import kr.heartof.springWeb_01.vo.user.UserVO;

public class Test {
	public static void main(String[] args) {
		UserVO vo = new UserVO();
		vo.setUSR_CD("1");
		
		if(EnumUsrCD.COMPANY_USER.getKey().equals(vo.getUSR_CD())) {
			System.out.println(EnumUsrCD.PRIVATE_USER);
		} else {
			System.out.println(EnumUsrCD.COMPANY_USER);
		}
	}
}
