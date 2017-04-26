package day13.quiz;

import java.util.Arrays;

public class Quiz03 {
	public static void main(String[] args) {
		Data d1 = new Data(6);
		Data d2 = new Data(7);
		Data d3 = new Data(1);
		
		Data[] unsort = new Data[]{d1, d2, d3};
		Arrays.sort(unsort);
		
		System.out.println(Arrays.toString(unsort));
		
	}
}
