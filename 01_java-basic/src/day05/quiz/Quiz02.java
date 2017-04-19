package day05.quiz;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] args) {
		int[] arr = {6,8,3,9,7,4};
		// 순서 바꾸기
		Scanner sc = new Scanner(System.in);
		System.out.print("바꿀 인덱스 : ");
		int first = sc.nextInt(); 
		System.out.print("바꿀 인덱스 : ");
		int second = sc.nextInt();
		
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
		
		System.out.println(Arrays.toString(arr));
		
		sc.close();
	}
}
