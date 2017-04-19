package day03;

public class Test01 {
	public static void main(String[] args) {
		
		byte b = 100;
		//묵시적 형변환 : small -> big
		int i = b;
		System.out.println(i);
		
		//Type mismatch: cannot convert from int to byte
		//컴파일 에러 발생
		int i2 = 100;
//		byte b2 = i2;
		
		//명시적 형변환 : big -> small
		byte b2 = (byte)i2;
		System.out.println(b2);
		
		//소문자 a, 대문자 A의 아스키 코드를 화면에 출력
//		char c = 'a';
//		char c2 = 'A';
		
//		int asc1 = c;
//		int asc2 = c2;
		
		
		//(팁)변수가 한 번밖에 쓰이지 않는 경우 없애는 것이 좋다.
		System.out.println("소문자 a의 아스키 코드 : " + (int)'a');
		System.out.println("대문자 A의 아스키 코드 : " + (int)'A');
		
	}
}