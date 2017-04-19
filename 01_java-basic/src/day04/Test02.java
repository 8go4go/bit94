package day04;

public class Test02 {
	public static void main(String[] args) {
		
//		for(int i = 1; i < 10; i++) {
//			System.out.printf("2 * %d = %d\n", i, 2 * i);
//			
//		}
//		
//		System.out.println();
//		
//		for(int i = 1; i < 10; i++) {
//			System.out.printf("3 * %d = %d\n", i, 3 * i);
//		}
		
		for(int dan = 2; dan < 10; dan++) {
			for(int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %d\n", dan, i, dan * i);
			}
		}
	
	}
}