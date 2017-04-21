package day10.exam;

import java.util.Scanner;

public class GameTest {
	final static char A = 'A';
	final static char B = 'B';
	final static char C = 'C';
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game game = null;
		int score = 0;
		boolean isExit = false;
		while(!isExit) {
			System.out.println("게임을 선택하세요.");
			System.out.println("A. 가위바위보 ");
			System.out.println("B. 주사위 값 맞추기");
			System.out.println("C. 종료 ");

			char c = sc.nextLine().charAt(0);
			int result = -1;
			switch(c) {
			case A:
				game = new ScissorsRockPaper();
				System.out.println("가위바위보 게임입니다. \n 가위바위보중 하나를 선택하세요. \n (1:가위, 2:바위, 3보) ");
				result = game.startGame(Integer.parseInt(sc.nextLine()));
				break;
			case B:
				game = new Dice();
				System.out.println("주사위 값 맞추기 게임입니다.  \n 주사위을 선택하세요(1~6값 중 하나) ");
				result = game.startGame(Integer.parseInt(sc.nextLine()));
				break;
			case C:
				isExit = true;
				break;
			default :
				System.out.println("다시 입력하세요");
				break;
			}
			
			if(result != -1) {
				if(result == 1) {
					score++;
					System.out.println("You win");
				} else
					System.out.println("You lose");
			}
		}
		
		System.out.printf("당신의 total score는  %d입니다.\n", score);
	}
}
