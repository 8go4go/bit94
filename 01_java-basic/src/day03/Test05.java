package day03;

import java.util.Random;

public class Test05 {
	public static void main(String[] args) {

		byte b1 = 1;
		byte b2 = 2;

		// Type mismatch: cannot convert from int to byte
		// byte b3 = b1 + b2;
		byte b3 = (byte) (b1 + b2);

		// int보다 작은 타입의 산술 연산의 결과는 int로 형변환 된다.
		System.out.println('a' + 'A');

		System.out.println(5 / 2);

		// int로 계산된 2를 double형으로 대입하기 때문에 2.0
		double d1 = 5 / 2;

		System.out.println(d1);

		System.out.println(5 / 2.0);
		System.out.println(5 / (double) 2);

		System.out.println(1 % 2);
		System.out.println(2 % 2);
		System.out.println(3 % 2);
		System.out.println(4 % 2);
		System.out.println(5 % 2);
		System.out.println(6 % 2);

		// 1~100 사이의 숫자를 랜덤하게 생성한 후 아래와 같이 출력될 수 있도록 프로그램을 작성
		// 생성된 5는 홀수입니다.

//		Random r = new Random();

//		int ran = r.nextInt(100) + 1;
		int ran = new Random().nextInt(100) + 1;
 
		// if((ran % 2) == 0)
		// System.out.println("생성된 " + ran + "는 짝수입니다.");
		// else
		// System.out.println("생성된 " + ran + "는 홀수입니다.");

		System.out.println((ran % 2 == 0) ? "생성된 " + ran + "는 짝수입니다." : "생성된 " + ran + "는 홀수입니다.");
		System.out.printf("생성된 %d는 %s입니다.", ran, 
				(ran % 2 == 0) ? "짝수" : "홀수");

	}
}