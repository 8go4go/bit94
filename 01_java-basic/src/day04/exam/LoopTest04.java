/*
 * 2부터 10사이의 수를 입력 받아 배수만을 출력하는 프로그램을 작성하시오
 * 배수는 10개 출력합니다.
 * 출력형식 >
 * 수를 입력하세요(2 - 10) : 10
 * 10의 배수 : 10 20 30 40 50 60 70 80 90 100
 */

package day04.exam;

import java.util.Scanner;

public class LoopTest04 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		final int MAX_VALUE = 10;
		
		System.out.print("수를 입력하세요(2 - 10) : ");
		num = Integer.parseInt(sc.nextLine());
		
		System.out.print(num + "의 배수 : ");
		
		for(int i = 1; i <= MAX_VALUE; i++) {
			System.out.print(num * i + "\t");
		}
		
	}
}