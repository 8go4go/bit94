package day04.quiz;

import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		
//		for(int i = 0; i < num; i++) {
//			for(int j = 0; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		String star = "";
		for(int i = 1; i <= num; i++) {
			System.out.println(star += "*");
		}
		
	}
}
