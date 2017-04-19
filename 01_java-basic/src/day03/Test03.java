package day03;

import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		
		TestSub03 sub = new TestSub03();
		//메서드 호출
		sub.call();
		
		
		//Random cannot be resolved to a type
		Random r = new Random();
		//0부터 지정된 숫자(10)까지
		//단, 지정된 숫자는 제외
		//0~9
		System.out.println(r.nextInt(10));
		
		//1~10
		System.out.println(r.nextInt(10)+1);		
		
		//2~9
		System.out.println(r.nextInt(8)+2);
		
		//11~20
		System.out.println(r.nextInt(10)+11);
		
	}
}