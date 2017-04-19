package day05.exam;

import java.util.Arrays;

public class Exam01 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		int goRight = 0;
		int goLeft = arr.length - 1;
		
		for(int i=0; i < arr.length / 2 + (arr.length % 2 == 0 ? 0 : 1); i++) {
			if(goRight == goLeft) break;
			
			int temp = arr[goRight];
			arr[goRight++] = arr[goLeft];
			arr[goLeft--] = temp;
		}
		
		System.out.println("arr count["+arr.length+"]" + Arrays.toString(arr));
	}
}

