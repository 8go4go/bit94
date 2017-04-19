package day03;

public class Test08 {
	public static void main(String[] args) {
		
		//switch문은 같다(==) 비교만 가능
		
		int a = 2;
		
		//switch의 수식 자리에 대입 가능한 타입
		//byte, short, char, int(~1.4버전) -> enum 추가(1.5버전) -> String 추가(1.7버전)
		switch(a) {
			case 1:
				System.out.println(a + 10);
				break;
			case 2:
				System.out.println(a + 100);
				break;
			case 3:
				System.out.println(a + 1000);
				break;
			default:
				System.out.println("default...");
		}
		
	}
}
