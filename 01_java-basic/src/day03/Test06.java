package day03;

public class Test06 {
	public static void main(String[] args) {
		
		int a = 5;
		
		//a = a + 1;
		//b = a;
		int b = ++a;
		
		System.out.println("a : " + a + "\nb : " + b);
		
		a = 5;
		
		//b = a;
		//a = a + 1;
		b = a++;
		
		System.out.println("a : " + a + "\nb : " + b);
		

		System.out.println((5 == 5) ? "같다" : "다르다");
		System.out.println((5 != 5) ? "같다" : "다르다");
		

		int k = 5;
		int m = 5;
		
		//배정 연산자는 마지막에 수행한다.
		m *= 5 + 3; //40
		
		System.out.println((k > 5 && m++ == 5));
		System.out.println((k == 5 || m++ == 5));
		//앞의 조건이 거짓이기 때문에 뒤의 조건을 수행하지 않는다.
		System.out.println(m); //5
		
		System.out.println((k > 5 & m++ == 5));
		//앞의 조건이 거짓이어도 뒤의 조건을 수행한다.
		System.out.println(m); //6
		
	}
}