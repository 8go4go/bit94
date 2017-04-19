package day02;

public class Test06 {
	public static void main(String[] args) {
		//나의 이름은 홍길동 이고, 나이는 22세 입니다.
		//%n == \n
		System.out.printf("나의 이름은 %s 이고, 나이는 %d세 입니다.%n", "홍길동", 22);
		
		System.out.printf("|%5d|", 22); //5자리 오른쪽부터 채움
		System.out.println();
		System.out.printf("|%-5d|", 22); //5자리 왼쪽부터 채움
		System.out.println();
		System.out.printf("|%05d|", 22); //5자리 빈 공간 0으로 채움
		
		System.out.println();
		System.out.printf("|%f|", 22.1); //소수점 아래 6자리 확보(자동)
		
		System.out.println();
		System.out.printf("|%6.2f|", 22.1);
	}
}