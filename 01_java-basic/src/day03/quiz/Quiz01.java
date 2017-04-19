package day03.quiz;

import java.util.Random;

public class Quiz01 {
	public static void main(String[] args) {
		
		/*
		 * 랜덤하게 금액을 얻습니다.
		 * 랜덤한 금액은 1000원 부터 10000원까지 얻을 수 있습니다.
		 * 단, 금액은 1000단위로 생성합니다.
		 * 
		 * 생성된 금액에 따라서 아래와 같이 출력하도록 프로그램을 작성합니다.
		 * 
		 * 조건 : 랜덤하게 생성된 금액이 
		 * 5000원 미만일 경우 : 치즈버거 구입 가능
		 * 5000원 ~ 7000원 사이일 경우 : 불고기 버거 세트 구입 가능
		 * 7000원보다 클 경우 : 패밀리 세트 구입 가능 
		 * 
		 * 어서오세요^^ 롯데리아입니다.
		 * 현재 고객님이 가진 금액은 2000원 입니다.
		 * 고객님은 치즈버거를 사실 수 있습니다.
		 */
		
		int money = (new Random().nextInt(10) + 1) * 1000;
		
		//하나의 값으로 초기화를 해 놓으면 if문 하나를 줄일 수 있다.
//		String burger = "";
		String burger = "패밀리 세트";
		String result = "";
		
		if(money < 5000)
			burger = "치즈버거";
		else if(money < 7000)
			burger = "불고기 버거 세트";
//		else
//			burger = "패밀리 세트";
		
		result = "어서오세요^^ 롯데리아입니다.\n"
				+ "현재 고객님이 가진 금액은 " + money + "원 입니다.\n"
				+ "고객님은 " + burger + "를 사실 수 있습니다.";
		
		System.out.print(result);
		
	}
}