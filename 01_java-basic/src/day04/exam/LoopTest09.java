/*
 *  10부터 20사이의 랜덤한 숫자를 생성한 다음 생성된 숫자 만큼의 소수를 출력하는 프로그램을 작성하시오
 */

package day04.exam;

import java.util.Random;

public class LoopTest09 {
	public static void main(String[] args) {
		
		int rand = new Random().nextInt(11) + 10;
		int check = 0;
		int count = 0;
		
		int i = 1;
		
		System.out.println("생성된 수 : " + rand);
		
		while(count < rand) {
			check = 0;
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) {
					if(j == 1)
						check++;
					else if(i == j)
						check++;
					else {
						check = 0;
						break;
					}
				}
			}
			if(check == 2) {
				System.out.printf("%2d\t", i);
				count++;
			}
			i++;
			
		}
		
	}
}