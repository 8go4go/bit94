/*
 * 하나의 숫자를 입력 받아 입력 받은 수의 절대값을 구하는 프로그램을 작성하시오
 *  출력예시>
 *  숫자를 입력하세요 : -3
 *  -3의 절대값 : 3
 *  숫자를 입력하세요 : 3
 *  3의 절대값 : 3
 */

package day03.exam;

import java.util.Scanner;

public class Exam07 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		int abs = 0;
		
		
		if(num < 0)
			abs = -num;
		else
			abs = num;
		
		System.out.println(num + "의 절대값 : " + abs);
		
	}
}