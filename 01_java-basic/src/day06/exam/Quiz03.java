package day06.exam;

import java.util.Random;

public class Quiz03 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		int[] students = {1,2,3,4,5};
//		int[] tickets = {0,1,1,1,2};
		
		
		Random r = new Random();
//		for(int i=0; i < tickets.length ; i++) {
		for(int i=0; i < students.length ; i++) {
			int ticket = r.nextInt(i + 1);
			int student = students[i];
			
			Node newNode = new Node();
//			newNode.ticket = tickets[i];
			newNode.ticket = ticket;
			newNode.student = student;
			
			System.out.println("Ticket : " + newNode.ticket + " student : " + student);
			if(i == 0) {
				list.insert(newNode);
			} else {
				list.insert(newNode.ticket, newNode);
			}
		}
		
		list.print();
	}
}