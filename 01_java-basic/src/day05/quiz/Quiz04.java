package day05.quiz;

import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		int[] arr = {6,8,3,9,7,4,6,8,3,9,7,4,6,8,3,9,7,4,};
		Scanner sc = new Scanner(System.in);
		
		int foundCount = 0;
		while(true) {
			System.out.print("\n수를 입력 : ");
			int selectedValue = sc.nextInt();
			
			if(selectedValue == -1) {
				System.out.println("종료합니다.");
				break;
			}
			
			for(int value : arr) {
				if(value == selectedValue) {
					foundCount++;
				}
			}
			
			System.out.printf("배열에 %d개가 들어 있습니다.", foundCount);
			foundCount = 0;
		} 
		sc.close();
	}
}
