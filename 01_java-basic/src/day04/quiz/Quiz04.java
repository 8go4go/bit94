package day04.quiz;

import java.util.Scanner;
import java.util.Random;

public class Quiz04 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = 0; //사용자에게 입력 받은 값
//		int answer = new Random().nextInt(1000) + 1; //난수 생성
		int answer = 400;
		
		int i = 0; //반복 조건 변수
		boolean check = false; //정답 체크
		String guide = "";
		
		final int COUNT = 10;
		
		System.out.println("1부터 1000사이의 숫자를 맞추는 게임입니다. (총 10회)");
		
		do {
			System.out.printf("\n%2d회. 숫자를 입력하세요(1 - 1000) : ", ++i);
			num = Integer.parseInt(sc.nextLine());
			
//			if(num < answer) {
//				guide = "큰 값";
//			}
//			else if(num == answer) {
//				guide = "정답입니다.";
//				check = true;
//				break;
//			}
//			else {
//				guide = "작은 값";
//			}
//			
//			System.out.println(num + "보다 " + guide + " 입니다.");
			
			if(num == answer) {
				System.out.println("정답입니다.");
				check = true;
				break;
			}
			
			System.out.printf("%d보다 %s 입니다.", num, (num > answer) ? "작은 값" : "큰 값");
		} while(i < COUNT);
		
		if(!check) {
			System.out.println(i + "회 안에 맞추기 게임에 실패하였습니다.\n"
					+ "정답은 " + answer + "입니다.");
		}
		else {
			System.out.println(guide);
		}
		
	}
}