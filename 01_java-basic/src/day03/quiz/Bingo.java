package day03.quiz;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
	public static void main(String[] args) {
		
		Bingo bg = new Bingo();
		
		int[] board = {1, 2, 3, 4, 5,
					   6, 7, 8, 9, 10,
					   11, 12, 13, 14, 15,
					   16, 17, 18, 19, 20,
					   21, 22, 23, 24, 25};
		
		int i = 0;
		int bingoCount = 0;
		int choiceNum = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for(i = 0; i < board.length; i++) {
			int temp, rand;
			rand = new Random().nextInt(25);
			
			temp = board[i];
			board[i] = board[rand];
			board[rand] = temp;
		}
		
		bg.printBoard(board);
		
		while(bingoCount < 3) {
			System.out.print("\n숫자 입력 : ");
			choiceNum = sc.nextInt();
			
			for(i = 0; i < board.length; i++) {
				if(choiceNum == board[i]) {
					board[i] = 42;
					bg.printBoard(board);
					break;
				}
			}
			
			bingoCount = bg.bingoCheck(board);
		}
		
	}
	
	private void printBoard(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(i % 5 == 0)
				System.out.println();
			System.out.print(((arr[i] == 42)? "*" : arr[i]) + "\t");
		}
	}
	
	private int bingoCheck(int[] arr) {
//		int check = 0;
//		int way = 0;
//		int starCount = 0;
		int diagonalRightCount = 0;
		int diagonalLeftCount = 0;
		
		int widthCount = 0;
		int heightCount = 0;
		
		int bingoLine = 0;
		
		
		for(int i = 0; i < 5; i++) {
			widthCount = 0;
			heightCount = 0;
//			starCount = 0;
			for(int j = 0; j < 5; j++) {
//				if(check == 0) {
					//가로 검사
					if(arr[i * 5 + j] == 42)
						widthCount++;
					if(widthCount == 5) {
						bingoLine++;
					}
//					if(way == 24) {
//						i = 0; j = 0; check = 1; starCount = 0;
//					}
//				}
//				if(check == 1) {
					//세로 검사
//					way = i + j * 5;
					if(arr[i + j * 5] == 42)
						heightCount++;
					if(heightCount == 5) {
						bingoLine++;
					}
//					if(way == 24) {
//						i = 0; j = 0; check = 2; heightCount = 0;
//					}
//				}
//				if(check == 2) {
					//오른쪽 대각선 검사
//					way = ;
					if(i == j) {
						if(arr[i * 5 + j] == 42)
							diagonalRightCount++;
						if(diagonalRightCount == 5) {
							bingoLine++;
						}
//						if(way == 24) {
//							i = 0; j = 0; check = 3; diagonalRightCount = 0;
//						}
					}
//				}
//				if(check == 3) {
					//왼쪽 대각선 검사
//					way = ;
					if(i + j == 4) {
						if(arr[i * 5 + j] == 42)
							diagonalLeftCount++;
						if(diagonalLeftCount == 5) {
							bingoLine++;
						}
//						if(way == 24) {
//							i = 0; j = 0; check = 4;
//						}
					}
//				}
				
			}
		}
		return bingoLine;
	}
	
}