package day02;

public class Test01 {
	public static void main(String [] args) {
		//매개변수 공간의 크기 확인
		System.out.println(args.length);
		
		if(args.length == 2) {
			System.out.println(args[0]);
			System.out.println(args[1]);
		}
		
		int i = 10;
		
		System.out.println(i);
	}
}
