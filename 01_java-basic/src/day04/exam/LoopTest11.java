/*
 * 11. 아래와 같이 출력되는 로또 프로그램을 작성하시오
 * 작성시 주의사항
 * - 로또번호는 1 - 45 사이의 숫자만 나와야 합니다.
 * - Set 별 중복된 숫자가 없어야 합니다.
 */

package day04.exam;

import java.util.Random;

public class LoopTest11 {
	public static void main(String[] args) {
		
		final int LOTTO_SET = 5;
		final int LOTTO_COUNT = 6;
		
		int[] lotto = new int[LOTTO_SET * LOTTO_COUNT];
		
//		for(int i = 0; i < LOTTO_SET; i++) {
//			System.out.printf("Set %d: ", i + 1);
//			for(int j = 0; j < LOTTO_SET * 6; j++) {
//				lotto[j] = new Random().nextInt(45) + 1;
//				
//				if(lotto[j] == lotto[i * 5 + (j + 1)]) {
//					
//				}
//			}
//		}
		
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = new Random().nextInt(45) + 1;
			for(int j = 0; j < lotto.length; j++) {
				if(i != j) 
					if(lotto[i] == lotto[j]) {
						i--; 
						break;
					}
			}			
		}
		
		int j = 0;
		
		for(int i = 0; i < LOTTO_SET; i++) {
			System.out.printf("\nSet %d: ", i + 1);		
			for(j = 0 ; j < LOTTO_COUNT; j++) {
				System.out.printf("%2d ", lotto[i * LOTTO_COUNT + j]);
			}
		}
		
	}
}