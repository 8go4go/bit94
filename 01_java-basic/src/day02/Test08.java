package day02;

public class Test08 {
	public static void main(String[] args) {
		byte b = 100;
		short s = 100;
		int i = 100;
		long l = 100;
		
		//(필수)float 은 반드시 값 뒤에 f를 붙인다.
		float f = 1.1f;
		//정수 값 뒤에 d를 붙이면 double형
		double d = 1.1;
		d = 1d;
		
		char c = 'a';
		char c2 = 97; //'a'의 숫자값
		
		//유니코드 사용 : 16진수로 표현
		char c3 = '\u0061'; //97
		
		//모두 a 출력
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		
		int i2 = 'a'; //자동 형변환
		System.out.println(i2); //97
		
		boolean bool = true;
	}
}
