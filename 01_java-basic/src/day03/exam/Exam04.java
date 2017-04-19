/*
 * 화면에서 하나의 정수를 입력 받고 정수를 나눌 수를 입력 받은 다음 몫과 나머지를 화면에 출력하시오
 * 출력형식 >
 * 정수를 입력하세요 : 10
 * 나눌 수를 입력하세요 : 7
 * 몫 : 1
 * 나머지 : 3
 */

package day03.exam;

import java.util.Scanner;

public class Exam04 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.print("나눌 수를 입력하세요 : ");
		int mod = Integer.parseInt(sc.nextLine());
		
		System.out.println("몫 : " + num / mod);
		System.out.println("나머지 : " + num % mod);
		
	}
}