/*
 * 1 - 100사이의 랜덤 숫자 5개를 생성하여 생성된 숫자의 합계와 평균을 구하시오
 */

package day04.exam;

import java.util.Random;

public class LoopTest03 {
	public static void main(String[] args) {
		
		String randSet = "";
		int rand = 0;
		double sum = 0.0;
		
		final int MAX_VALUE = 5;
		
		for(int i = 0; i < MAX_VALUE; i++) {
			rand = new Random().nextInt(100) + 1;
			randSet += rand +", ";
			sum += rand;
		}
		
//		System.out.printf("%s 의 합계 : %.1f\n%s 의 평균 : %.1f", randSet, sum, randSet, sum / MAX_VALUE);
		System.out.printf("%s\n합계 : %.1f\n평균 : %.1f", randSet, sum, sum / MAX_VALUE);
		
	}
}