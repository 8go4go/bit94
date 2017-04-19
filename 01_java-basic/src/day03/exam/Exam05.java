/*
 * 서울랜드 동물원에 놀러 갔습니다. 동물원 요금이 5세 미만은 무료, 5 - 11세 까지 2500원
 * 12 부터는 5000원 입니다.
 * 화면에서 나이를 입력 받아 요금을 계산하여 출력하는 프로그램을 작성하시오
 * 출력예시>
 * 나이를 입력하세요 : 3
 * 입장료는 무료입니다.
 * 나이를 입력하세요 : 7
 * 입장료는 2500원 입니다.
 * 나이를 입력하세요 : 22
 * 입장료는 5000원 입니다.
 */

package day03.exam;

import java.util.Scanner;

public class Exam05 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이를 입력하세요 : ");
		int age = Integer.parseInt(sc.nextLine());
		String fee = "5000원";
		
		if(age >= 0 && age < 5)
			fee = "무료";
		else if(age <= 11)
			fee = "2500원";
		
		System.out.println("입장료는 " + fee + " 입니다.");
		
	}
}