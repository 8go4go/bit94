package day02;

import day01.Second;
import java.util.Random;

public class Test09 {
	public static void main(String[] args) {
		Test01 t01 = new Test01();
		Test04 t04 = new Test04();
		
		//Second 클래스는 같은 위치(패키지)가 아니기 때문에 사용하기 위해서는 위치를 import해서 알려줘야 한다.
		//import 패키지이름.클래스명
		//import는 클래스 선언 위에 명시한다.
		Second s = new Second();
		Random r = new Random();
	}
}