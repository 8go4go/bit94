/*
 * 1 부터 100사이의 숫자 중에서 소수를 출력하는 프로그램을 작성하시오.
 * 소수는 그 수 자신과 1을 제외한 다른 정수로는 나누어 떨어지지 않는 정수
 * 3이 소수인지 판별 :
 * 3 % 1 == 0 (참)
 * 3 % 2 == 0 (거짓)
 * 3 % 3 == 0 (참)
 * 참인 경우가 2개인 경우 소수
 */

package day04.exam;

public class LoopTest08 {
	public static void main(String[] args) {
		
		int check = 0;
		
		for(int i = 1; i <= 100; i++) {
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
			}
		}
		
	}
}