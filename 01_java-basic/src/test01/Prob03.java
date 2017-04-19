package test01;

public class Prob03 {
	// 3. 1 – 10 사이의 숫자중에서 3의 배수는 그대로 출력하고 3의 배수가 아닌 숫자는 2배수를
	// 출력하는 프로그램을 작성하시오
	//
	// 출력예시 >
	// 2 4 3 8 10 6 14 16 9 20
	public static void main(String[] args) {
		String printVal = "";
		for (int i = 1; i <= 10; i++) {
			if(i % 3 == 0)
				printVal += i + " ";
			
			if(i % 2 == 0)
				printVal += i + " ";
		}
		
		System.out.println(printVal);
	}
}
