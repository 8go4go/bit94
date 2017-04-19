package day05.exam;

import java.util.Random;

public class Exam02 {
	public static void main(String[] args) {
		int[] exceptedBalls = new int[30];
		Random r = new Random();
		int lastIndex = 0;
		while(true) {
			int pickedValue = r.nextInt(45) + 1;
			boolean isExist = false;
			
			for(int v=0; v < lastIndex + 1; v++) {
				if(exceptedBalls[v] == pickedValue) {
					isExist = true;
					break;
				}				
			}

			if(!isExist) {
				exceptedBalls[lastIndex] = pickedValue;	
				lastIndex++;
			}
			
			if(lastIndex > exceptedBalls.length - 1) 
				break;
		}
		
		for (int i = 0; i < exceptedBalls.length; i++) {
			System.out.println("["+exceptedBalls[i]+"]");
		}
	}
}
