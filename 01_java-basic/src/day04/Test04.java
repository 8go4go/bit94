package day04;

public class Test04 {
	public static void main(String[] args) {
		
		int num = 2;
		boolean memo = false;
		
//		for(int i = 1; i < 4; i++) {
//			for(int j = 1; j < 4; j++) {
//				System.out.println(i + " - " + j);
//				if(j == num) {
//					memo = true;
//					break;
//				}
//			}
//			if(memo)
//				break;
//		}
		
		outer : for(int i = 1; i < 4; i++) {
			for(int j = 1; j < 4; j++) {
				System.out.println(i + " - " + j);
				if(j == num) {
					break outer;
				}
			}
		}
		
		
	}
}
