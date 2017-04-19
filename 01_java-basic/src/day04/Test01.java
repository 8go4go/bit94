package day04;

public class Test01 {
	public static void main(String[] args) {
		
		/*
		 * for(1. 초기화; 2. boolean형식의 조건식; 3. 값의 증감) {
		 * 		4. 실행 문장(조건식이 참이면)
		 * }
		 * 5. for문을 벗어난 문장
		 * 
		 * 실행순서
		 * 1 -> 2(참) -> 4 -> 3
		 *   -> 2(참) -> 4 -> 3 
		 *   ... (반복)
		 *   -> 2(거짓) -> 5
		 *   
		 * 1, 2, 3번 항복은 생략 가능하다.
		 */
		
		for(int i = 1; i < 6; i++) {
			System.out.println(i * 10);
		}
		
	}
}