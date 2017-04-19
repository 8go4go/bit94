package test01;

import java.util.Scanner;

public class Prob04 {
	// 4. 하나의 수를 입력받은 다음 입력받은 수까지의 짝수와 홀수, 전체 합을 구하는 프로그램을
	// 작성하시오
	// 출력예시 >
	// 수 입력 : 10
	// 홀수 합 : 25
	// 짝수 합 : 30
	// 전체 합 : 55

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("수 입력 : ");
		int lastNum = Integer.parseInt(sc.nextLine());

		int odd = 0;
		int even = 0;
		for (int i = 1; i < lastNum + 1; i++) {
			if (i % 2 == 0)
				even = even + i;
			else
				odd = odd + i;
		}
		
		System.out.println("홀수 합 : " + odd);
		System.out.println("짝수 합 : " + even);
		System.out.println("전체 합 : " + (odd + even));

	}
}
