package day04;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		
		int i = 0;
		Scanner sc = new Scanner(System.in);
		
		for(i = 1; i < 11; i++) { 
			System.out.println(i);
		}
		
		i = 1;
		while(i < 11) {
			System.out.println(i);
			i++;
		}
		
		while(true) {
			System.out.print("수 입력 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			if(num == -1)
				break;
		}
		
	}
}