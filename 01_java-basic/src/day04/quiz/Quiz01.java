/*
 * 1부터 10 사이의 숫자 중에서
 * 3의 배수는 그대로 출력하고
 * 3의 배수가 아닌 숫자는 2의 배수를 출력한다.
 */

package day04.quiz;

public class Quiz01 {
	public static void main(String[] args) {
		
		for(int i = 1; i <= 10; i++) {
//			if(i % 3 == 0)
//				System.out.println(i);
//			else
//				System.out.println(i * 2);
			
//			int val = i;
//			
//			if(i % 3 != 0)
//				val = i * 2;
//			System.out.println(val);
			
			System.out.println((i % 3 == 0) ? i : i * 2);
		}
		
	}
}