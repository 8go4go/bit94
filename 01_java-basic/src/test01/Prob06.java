package test01;

import java.util.Scanner;

public class Prob06 {
//	6. 임의의 두 수를 입력 받아 두 수 사이의 합을 구하는 프로그램을 작성하시오
//	 출력형식 >
//	 수를 입력하세요 : 3
//	 수를 입력하세요 : 5
//	 3 부터 5까지의 합은 12 입니다.	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("수 입력 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("수 입력 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		int min = 0, max = 0;
		int tot = 0;
		if(num1 > num2) {
			min = num2;
			max = num1;
		} else if(num1 < num2) {
			min = num1;
			max = num2;
		} else {
			max = num1;
			min = num1;
		}
		
		for(int i = min; i <= max ; i++ ){
			tot += i;
		}
		
		System.out.printf("%d 부터 %d까지의 합은 %d입니다.", min, max, tot);
			
	}
}
