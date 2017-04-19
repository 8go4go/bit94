/*
 * 보통 시험에는 과락이 있습니다. 만약, 과락의 기준이 되는 점수가 60점이라면 1 - 100사
 * 이의 랜덤 숫자를 생성하여 생성된 점수가 합격인지 불합격인지 판단하는 프로그램을 작성
 * 하시오
 * 출력예시>
 * 생성된 점수 : 70점(합격)
 */

package day03.exam;

import java.util.Random;

public class Exam08 {
	public static void main(String[] args) {
		
		int score = new Random().nextInt(100) + 1;
		String result = score <= 60 ? "불합격" : "합격";
		
		System.out.println("생성된 점수 : " + score + "점(" + result + ")");
		
	}
}