package day03;

import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		
		Random r = new Random();
		
		//1~10
		int num1 = r.nextInt(10)+1;
		int num2 = r.nextInt(10)+1;
		
		System.out.println("첫 번째 수 : " + num1);
		System.out.println("두 번째 수 : " + num2);
		
		//생성된 두 수 중에서 큰 수를 max란 이름의 변수에 저장
		//3항 연산자 이용
		int max = (num1>num2) ? num1 : num2;
		
		System.out.println("큰 수는 " + max + "입니다.");
		
		//두 수 중에서 작은 수를 min이란 변수에 저장하고 출력
		int min = (num1>num2) ? num2 : num1;
		
		System.out.println("작은 수는 " + min + "입니다.");		
		
	}
}