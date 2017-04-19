package day06.exam;

import java.util.Random;

class Data {
	Data next;
	Data pre;
	int ticketNumber;
	int student;
}

public class Exam03 {
	public static void main(String[] args) {
		Data head = new Data();
		Data tail = head;

		Random r = new Random();
		int[] student = {1,2,3,4,5,};
		
		int ticketNumber = r.nextInt(1);
		tail.student = student[0];
		tail.ticketNumber = ticketNumber;
		System.out.println("Ticket Number : " + tail.ticketNumber + " student number : " + tail.student);
		
		for(int val=1 ; val < student.length; val++) {
			ticketNumber = r.nextInt(val + 1);
			System.out.println("Ticket Number : " + ticketNumber + " student number : " + student[val]);
//			ticketNumber = 1;
			if(ticketNumber == 0) {
				tail.next = new Data();
				Data preTemp = tail;
				tail = tail.next;
				tail.ticketNumber = ticketNumber;
				tail.student = student[val];
				tail.pre = preTemp;
			} 
			else {
				Data temp = tail;
				
				Data newNode = new Data();
				newNode.ticketNumber = ticketNumber;
				newNode.student = student[val];
				
				if(head.next == null && head.pre == null) {
					temp = head;
					head = newNode; 
					
				}
				
				for(int i=ticketNumber; i > 0; i--) {
					if(temp.pre != null) {
						temp = temp.pre;
					}
				}
				
				if(temp.pre != null) {
					newNode.next = temp.next;
					newNode.pre = temp;
					temp.next = newNode;
				} else {
					temp.pre = newNode;
					newNode.next = temp;
					head = newNode;					
				}
			}
		}

		Data t = head;
		while(t != null) {
			System.out.print(" " + t.student);
			t = t.next;
		}
	}
}
