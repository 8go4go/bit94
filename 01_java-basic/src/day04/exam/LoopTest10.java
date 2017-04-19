/*
 * 화면에서 행의 수와 열의 수를 입력 받아 아래와 같은 형식으로 출력되는 프로그램을 작성하시오
 * 주의 사항 :
 * 출력 행이 홀수일 경우 문자( "<" )를 먼저 출력, 짝수일 경우 문자( ">" )를 먼저 출력
 * 출력형식 >
 * 출력할 행의 수를 입력하세요(1-10) : 4
 * 출력할 열의 수를 입력하세요(1-10) : 4
 * >>>>
 * <<<<
 * >>>>
 * <<<<
 * 출력할 행의 수를 입력하세요(1-10) : 3
 * 출력할 열의 수를 입력하세요(1-10) : 3
 * <<<
 * >>>
 * <<<
 */

package day04.exam;

import java.util.Scanner;

public class LoopTest10 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int width, height;
		
//		String right = ">";
//		String left = "<";
		
		String print = "";
		
		boolean first = true;
		
		System.out.print("출력할 행의 수를 입력하세요(1-10) : ");
		width = Integer.parseInt(sc.nextLine());
		
		System.out.print("출력할 열의 수를 입력하세요(1-10) : ");
		height = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <= width; i++) {
			if(first) {
				print = (width % 2 == 0) ? ">" : "<";
				first = !first;
			}
			else
				print = (print.equals(">") ? "<" : ">");
			
			for(int j = 0; j < height; j++) {
				System.out.print(print);
			}
			System.out.println();
		}
	}
}