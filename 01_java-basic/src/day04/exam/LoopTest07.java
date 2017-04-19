/*
 * 화면에서 2 - 9사이의 숫자 2개를 입력 받아 두 숫자 사이의 구구단을 출력하는 프로그램을 작성하시오
 * 예를 들어 화면에서 4 와 8을 입력 받았다면 4단부터 8단까지 화면에 출력한다.
 * 구구단 출력시 각 단별로 줄넘김 처리한다.
 */

package day04.exam;

import java.util.Scanner;

public class LoopTest07 {
	public static void main(String[] args) {
	
		final int MIN_VALUE = 2;
		final int MAX_VALUE = 9;
		
		int min = 0, max = 0;
		int temp = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("구구단 입력하세요 : ");
		min = Integer.parseInt(sc.nextLine()); 
		
		System.out.print("구구단 입력하세요 : ");
		max = Integer.parseInt(sc.nextLine());
		
		if(min > max) {
			temp = min;
			min = max;
			max = temp;
		}
		
		for(int i = min; i <= max; i++) {
			for(int j = 1; j <= MAX_VALUE; j++) {
				System.out.printf("%d * %d = %3d\t", i, j, i * j);
			}
			System.out.println();
		}
		
	}
}