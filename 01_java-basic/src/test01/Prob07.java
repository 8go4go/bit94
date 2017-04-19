package test01;

import java.util.Scanner;

public class Prob07 {
//	7. 화면에서 행의 수와 열의 수를 입력 받아 아래와 같은 형식으로 출력되는 프로그램을 작성
//	하시오
//	주의 사항 :
//	출력 행이 홀수일 경우 문자( "<" )를 먼저 출력, 짝수일 경우 문자( ">" )를 먼저 출력
//	 출력형식 >
//	 출력할 행의 수를 입력하세요(1-10) : 4
//	 출력할 열의 수를 입력하세요(1-10) : 4
//	 >>>>
//	 <<<<
//	 >>>>
//	 <<<<
//	 출력할 행의 수를 입력하세요(1-10) : 3
//	 출력할 열의 수를 입력하세요(1-10) : 3
//	 <<<
//	 >>>
//	 <<<
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("출력할 행의 수를 입력하세요(1-10) : ");
		int row = Integer.parseInt(sc.nextLine());
		System.out.print("출력할 열의 수를 입력하세요(1-10) : ");
		int column = Integer.parseInt(sc.nextLine());
		
		String flag = row % 2 == 0 ? ">" : "<";
		boolean isSwitch = false;
		
		for(int i=1;i <= row; i++  ) {
			String rowStr = "";
			for(int j=1; j <= column; j++) {
				rowStr += flag; 
			}
			System.out.println(rowStr);
			
			if(!isSwitch) {
				isSwitch = true;
				flag = row % 2 == 0 ? "<" : ">";
			} else {
				isSwitch = false;
				flag = row % 2 == 0 ? "<" : ">";
			}
		}
	}
}
