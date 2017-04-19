package test01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int numerator = Integer.parseInt(sc.nextLine());

		System.out.print("나눌 수를 입력하세요 : ");
		int denominator = Integer.parseInt(sc.nextLine());

		System.out.println("몫 : " + (numerator / denominator));
		System.out.println("나머지 : " + +(numerator % denominator));
		
		sc.close();
	}	
}
