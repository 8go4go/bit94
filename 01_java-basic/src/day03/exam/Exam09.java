/*
 * 1 - 100사이의 랜덤숫자를 생성하여 숫자가 짝수인지 홀수인지 출력하는 프로그램을 작성하시오
 * 출력예시>
 * 생성된 숫자(19)은 홀수 입니다
 */

package day03.exam;

import java.util.Random;

public class Exam09 {
	public static void main(String[] args) {
		
		int num = new Random().nextInt(100) + 1;
		String result = "홀수";
		
		if(num % 2 == 0)
			result = "짝수";		
		
		System.out.println("생성된 숫자(" + num + ")은 " + result + " 입니다.");
		
	}
}