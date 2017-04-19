package day03;

public class Test02 {
	public static void main(String[] args) {
		final String IP = "192.168.0.111";
		//The final local variable IP cannot be assigned. It must be blank and not using a compound assignment
//		IP = "192.168.0.222"; //final을 사용함으로써(final 상수이므로) 값을 변경할 수 없게 되었다.
		
		System.out.println(IP);
		
		//문자열 상수
		System.out.println("오늘은 \"좋은날\"이란 책을 읽자");
		
		//Invalid escape sequence (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )
//		System.out.println("수업 소스 위치 : c:\java94\workspace");
		System.out.println("수업 소스 위치 : c:\\java94\\workspace");
	}
}