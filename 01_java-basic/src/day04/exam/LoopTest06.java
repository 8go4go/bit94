/*
 * 구구단을 아래와 같은 형식으로 출력하시오
 */

package day04.exam;

public class LoopTest06 {
	public static void main(String[] args) {
		
		int i = 0;
		
		System.out.print(":");
		for(i = 1; i < 10; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println("\n-------------------------------------------");
		
		for(i = 1; i <= 9; i++) {
//			if(i != 1)
				System.out.printf("%2d단", i);
//			else {
//				System.out.println();
//			}
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%4d", i * j);
			}
			System.out.println();
		}
		
	}
}