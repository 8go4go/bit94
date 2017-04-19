package day02;

public class Test10 {
	public static void main(String[] args) {
		int outer = 1;
		{
			int inner = 2;
			System.out.println("inner = " + inner);
			System.out.println("outer = " + outer);
			//int outer = 5; //2번 선언 되었다.
		}
			//System.out.println("inner = " + inner); //inner가 아직 선언되지 않았다.
			int inner = 3;
			System.out.println("inner = " + inner);
			System.out.println("outer = " + outer);
	}
}