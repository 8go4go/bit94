package day05.quiz;

public class Quiz01 {
	public static void main(String[] args) {
		int[] arr = {6,8,3,9,7,4};
		
		int min = arr[0];
		int max = arr[0];
		
		for(int value : arr) {
			min = (min > value) ? value : min;
			max = (max < value) ? value : max; 
		}
		
		System.out.println("최솟값 : " + min);
		System.out.println("최댓값 : " + max);
		
		
	}
}
	