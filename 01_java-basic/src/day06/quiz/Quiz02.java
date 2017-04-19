package day06.quiz;

public class Quiz02 {
	public static void main(String[] args) {
		Node head = new Node();
		Node tail = head;
		Node temp = head;
		
		tail.next = new Node();
		tail.next.data = 10;
		tail = tail.next;
		tail.pre = temp;
		
		tail.next = new Node();
		tail.next.data = 20;
		temp = tail;
		tail = tail.next;
		tail.pre = temp;
		
		tail.next = new Node();
		tail.next.data = 30;
		temp = tail;
		tail = tail.next;
		tail.pre = temp;
		
		Node t = head;
		
		System.out.println("=======forward======");
		while(t != null) {
			System.out.println(t.data);
			t = t.next;
		}
		
		t = tail;
		
		System.out.println("=======backward======");
		while(t != null) {
			System.out.println(t.data);
			t = t.pre;
		}
	}
}
