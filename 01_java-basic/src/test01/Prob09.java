package test01;

public class Prob09 {
//	9. 아래와 같은 배열을 선언 한 후 배열의 모든 요소가 홀수 인지 아닌지 판단하는 프로그
//	램을 작성하시오
//	 프로그램에 배열 선언 : int arr = { 6, 8, 3, 9, 7, 4 }
//	 출력형식 >
//	 배열의 모든 요소가 홀수는 아닙니다.
	
	public static void main(String[] args) {
		int[] arr = { 6, 8, 3, 9, 7, 4 };
		
		boolean isOdd = true;
		
		for(int val : arr) {
			if(val % 2 == 0) {
				isOdd = false;
				break;
			}
		}
		
		if(!isOdd)
			System.out.println("배열의 모든 요소가 홀수는 아닙니다.");
		else
			System.out.println("배열의 모든 요소가 홀수입니다.");
	}
}
