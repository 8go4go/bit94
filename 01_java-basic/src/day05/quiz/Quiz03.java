package day05.quiz;

public class Quiz03 {
	public static void main(String[] args) {
//		int[] arr = {6,8,3,9,7,4};
		int[] arr = {1,11,3,9,7,13};
		
		boolean isEven = true;
		for(int val : arr) {
			if(val % 2 != 0) {
				isEven = false;
				break;
			}
		}
		
		String result;
		if(!isEven)
			result = "배열의 모든 요소가 홀수가 아닙니다."; 
		else
			result = "배열의 모든 요소가 홀수입니다.";

		System.out.println(result);
	}
}
