package day06.exam;

import java.util.Scanner;

class Queue {
	private int[] queue;
	private int head, tail;
	public Queue(int size) {
		queue = new int[size];
		head = -1;
		tail = -1;
	}
	
	public void push(int value) throws Exception {
		int index = (head + 1) % queue.length;
		if(queue[index] == 0) {
			queue[index] = value;
			head = index;
		} else {
			throw new Exception("Queue is full");
		}
	}
	
	public int pop() throws Exception {
		int index = (tail + 1) % queue.length;
		if(queue[index] != 0) {
			tail = index;
			int returnValue = queue[index];
			queue[index] = 0;
			
			return returnValue;
		} else {
			throw new Exception("Queue is Empty");
		}
	}

	public void printQueue() {
		System.out.print("[");
		for(int val : queue)
			System.out.print(val + ",");
		System.out.print("]\n");
	}
}

public class Exam01 {
	public static void main(String[] args) {
		Queue queue = new Queue(3);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			printMenu();
			System.out.println("메뉴를 선택해주세요");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:
					System.out.print("저장할 수 입력 : ");
					try {
						queue.push(Integer.parseInt(sc.nextLine()));
					} catch (Exception e) {
						System.out.print("숫자를 삽입할 수 없습니다. \n");
					}
					queue.printQueue();
				break;
			case 2:
				System.out.print("뺀온 값은 : ");
				try {
					System.out.println(queue.pop());
				} catch (Exception e) {
					System.out.print("숫자를 가져올 수 없습니다. \n");
				}
				break;
			case 3:
				queue.printQueue();
				break;
			case 0:
				System.out.println("프로그램을 종료 합니다.");
				System.exit(0);
				break;
			default :
				System.out.println("메뉴를 잘못 입력하셨습니다.");
				break;
			}
		}
	}
	
	private static void printMenu() {
		System.out.println("---------------------");
		System.out.println("1. 수 저장하기");
		System.out.println("2. 저장된 값 빼오기");
		System.out.println("3. 전체값 보여주기");
		System.out.println("0. 종료하기");
		System.out.println("---------------------");
	}
}
