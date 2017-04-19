package day03.exam;

import java.util.Random;

public class Exam10 {
	public static void main(String[] args) {
		
		int score = new Random().nextInt(100) + 1;
		String result = "당신은 장학생";
		
		if(score < 60)
			result = "재수강";
		else if(score < 90)
			result = "잘했어요";
		
		System.out.println("당신의 점수는 " + score + "로 " + result);
		
	}
}