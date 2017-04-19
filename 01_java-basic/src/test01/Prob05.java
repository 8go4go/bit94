package test01;

import java.util.Random;

public class Prob05 {
//	5. 1 - 100사이의 랜덤 숫자 5개를 생성하여 생성된 숫자의 합계와 평균을 구하시오
	public static void main(String[] args) {
		Random r = new Random();
		
		int sum = 0;
		int length = 5;
		
		for(int i=0; i < length; i++) {
			int rNum = r.nextInt(100) + 1;
			sum += rNum;
		}
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (sum / length));
	}
}
