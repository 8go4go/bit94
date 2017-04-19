package day03.quiz;

import java.util.Random;
import java.util.Scanner;

public class ComputerBingo {
	public static void main(String[] args) {
		
		ComputerBingo cb = new ComputerBingo();
		
		Scanner sc = new Scanner(System.in);
		
		int[] board = {1, 2, 3, 4, 5,
				   	   6, 7, 8, 9, 10,
				   	   11, 12, 13, 14, 15,
				   	   16, 17, 18, 19, 20,
				   	   21, 22, 23, 24, 25};
		
		int value = 0;
		int index = 0;
//		int count = 0;
		
		int[] comBoard = cb.shuffleBoard(board);
		int[] myBoard = cb.shuffleBoard(board);
		
		int[] tempBoard = new int[25];
		
		cb.printBoard(myBoard);
		
		while(cb.getStarCount(myBoard) < 13) {
			System.out.print("\n숫자 입력 : ");
			value = Integer.parseInt(sc.nextLine());
			
			myBoard = cb.starCheck(myBoard, value);
			
			while(true) {
				index = new Random().nextInt(25);
				if(myBoard[index] != 42)
					break;
			}
			
			System.out.println("\n컴퓨터가 부른 숫자 : " + myBoard[index]);
			myBoard = cb.starCheck(myBoard, myBoard[index]);
		}

		for(int i = 0, len = myBoard.length; i < len; i++)
			comBoard[i] = myBoard[i];
		
		while(cb.checkBingo(comBoard) < 3) {
			cb.shuffleBoard(comBoard);
			cb.printBoard(comBoard);
			System.out.println();
		}
		
		System.out.println("----------------------------");
		cb.printBoard(comBoard);
		System.out.println("----------------------------");
		
	}
	
	private int[] shuffleBoard(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int temp, rand;
			rand = new Random().nextInt(25);
			
			temp = arr[i];
			arr[i] = arr[rand];
			arr[rand] = temp;
		}
		return arr;
	}
	
	private int[] printBoard(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(i % 5 == 0)
				System.out.println();
			System.out.print(((arr[i] == 42) ? "*" : arr[i]) + "\t");
		}
		return arr;
	}
	
	private int checkBingo(int[] arr) {
		int width = 0;
		int height = 0;
		int diaRight = 0;
		int diaLeft = 0;
		
		int bingoLine = 0;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				
				width = 0;
				height = 0;
				
				//가로 검사
				if(arr[i * 5 + j] == 42)
					width++;
				if(width == 5)
					bingoLine++;
				
				//세로 검사
				if(arr[i + j * 5] == 42)
					height++;
				if(height == 5)
					bingoLine++;
				
				if(i == j) {
					if(arr[i * 5 + j] == 42)
						diaRight++;
					if(diaRight == 5)
						bingoLine++;
				}
				
				if(i + j == 4) {
					if(arr[i * 5 + j] == 42)
						diaLeft++;
					if(diaLeft == 5)
						bingoLine++;
				}
				
			}
		}
		return bingoLine;
	}
	
	private int[] starCheck(int[] arr, int num) {
		
		for(int i = 0; i < arr.length; i++) {
			if(num == arr[i]) {
				arr[i] = 42;
				printBoard(arr);
			}
		}
		
		return arr;
	}

	private int getStarCount(int[] arr) {
		int count = 0;
		for(int i=0; i < arr.length; i++) {
			if(arr[i] == 42)
				count++;
		}
		return count;
	}
}