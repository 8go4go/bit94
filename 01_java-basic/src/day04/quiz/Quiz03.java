/*
 * 하나의 수를 입력받은 다음 입력받은 수 까지의 짝수와 홀수, 전체 합을 구한다.
 */

package day04.quiz;

import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		int odd = 0; //홀
		int even = 0; //짝
		
		for(int i = 0; i <= num; i++) {
//			if(i % 2 == 0)
//				even += i;
//			else
//				odd += i;
			if(i % 2 == 0) {
				even += i;
				continue;
			}
			odd += i;
		}
		
		System.out.println("홀수 합 : " + odd);
		System.out.println("짝수 합 : " + even);
//		System.out.println("전체 합 : " + sum);
		System.out.println("전체 합 : " + (odd + even));
		
	}
}
