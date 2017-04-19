package day05.exam;

import java.util.Random;

public class Exam03 {
	public static void main(String[] args) {
		// 학생위치
		int studentIndex = 0;
		// line
		int[] lines = { 100, 100, 100, 100, 100 };

		Random r = new Random();
		int student = 1;
		for (int i = 0; i < studentIndex + 1; i++) {
			if (studentIndex == lines.length)
				break;
			
			int ticketNumber = r.nextInt(studentIndex + 1);
			System.out.println("Ticket Number : " + ticketNumber + " student number : " + student);
			if (ticketNumber == 0) {// ticket 0 이면 위치 고수
				lines[i] = student;
			} else if (ticketNumber > 0) { // ticket 1이면
				int moveIndex = studentIndex - ticketNumber;
				for (int k = studentIndex; k > moveIndex; k--) {
					lines[k] = lines[k - 1];
				}
				lines[moveIndex] = student;
			}
			studentIndex++;
			student++;
		}

		for (int i = 0; i < lines.length; i++)
			System.out.print(lines[i] + " ");
	}
}
