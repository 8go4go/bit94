package day15.exam;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		System.out.println(sf.format(new Date()));
		
	}
	
	
	private static String getExtendedFileName(File f) {
		int index = f.getName().indexOf(".");
		String returnStr = f.getName().substring(index+1, f.getName().length());
		return returnStr;
	}
	
	private static void checkValidation(String email, String name, String gender
			,String phone) throws Exception {

		if(!phone.matches("[01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}]$"))
			throw new Exception("정확한 폰번호를 입력하세요");
	
	}
}
