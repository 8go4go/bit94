package day04;

import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		
		Random r = new Random();
		int num = r.nextInt(10) + 1;
		System.out.println("멈출 수 : " + num);
		
		for(int i = 1; i < 11; i++) {
			System.out.println(i);
			if(i == num)
				continue;
		}
	}
}
