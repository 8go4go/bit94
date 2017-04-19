package test01;

import java.util.Scanner;

public class Prob02 {
//	2. 하나의 숫자를 입력 받아 입력 받은 수의 절대값을 구하는 프로그램을 작성하시오
//	 출력예시>
//	 숫자를 입력하세요 : -3
//	 -3의 절대값 : 3
//	 숫자를 입력하세요 : 3
//	 3의 절대값 : 3
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		System.out.printf("절대값 : %d \n" , (num >= 0 ? num : -num));
		
		System.out.print("숫자를 입력하세요 : ");
		num = Integer.parseInt(sc.nextLine());
		System.out.printf("절대값 : %d \n" , (num >= 0 ? num : -num));
	}

}
