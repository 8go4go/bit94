package day05;

import java.util.Arrays;

public class Test05 {
	public static void main(String[] args) {
		int[] source = {1,2,3,4,5};
		int[] dest = new int [source.length];
		
		// source 배열의 일부를 dest 배열로 복사
		// 결과 source 0 0 1 2 3
		
//		int count=-1;
//		for(int val : source) {
//			if(count++ > 0) {
//				System.out.println(count);
//				dest[count] = val;
//			}
//		}		
//		
//		for(int val:dest) {
//			System.out.println(val);
//		}
		
		System.arraycopy(source, 0, dest, 0, source.length);
		
		System.out.println(Arrays.toString(dest));
	}
}
