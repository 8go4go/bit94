/*
 * 임의의 두 수를 입력 받아 두 수 사이의 합을 구하는 프로그램을 작성하시오
 * 출력형식 >
 * 수를 입력하세요 : 3
 * 수를 입력하세요 : 5
 * 3 부터 5까지의 합은 12 입니다.
 */

package day04.exam;

import java.util.Scanner;

public class LoopTest02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int min = 0, max = 0;
		int sum = 0;
		int temp = 0;
				
		System.out.print("수를 입력하세요 : ");
		min = Integer.parseInt(sc.nextLine());
		
		System.out.print("수를 입력하세요 : ");
		max = Integer.parseInt(sc.nextLine());
		
		if(min > max) {
			temp = min;
			min = max;
			max = temp;
		}
		
		for(int i = min; i <= max; i++) {
			sum += i;
		}
		
		System.out.printf("%d 부터 %d 까지의 합은 %d 입니다.", min, max, sum);
		
	}
}