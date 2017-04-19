/*
 * 화면에서 초를 입력 받고 몇 시간 몇 분 몇 초인지 환산해서 출력하시오
 * 초를 입력하세요 : 3661
 * 3661초는 1시간 1분 1초입니다.
 */

package day03.exam;

import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int hour = 0, min, sec;
		
		System.out.print("초를 입력하세요 : ");
		int second = Integer.parseInt(sc.nextLine());
		
		hour = (second / 3600) % 60;
		min = (second - hour * 3600) / 60;
		sec = (second - hour * 3600 - min * 60) % 60;
		
		System.out.printf("%d초는 %d시간 %d분 %d초 입니다.", second, hour, min, sec);
		
	}
}