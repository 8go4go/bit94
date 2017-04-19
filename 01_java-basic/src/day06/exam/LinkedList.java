package day06.exam;

/**
 * @author Bit503-24
 *
 */
public class LinkedList {
	private Node head;
	private Node tail;
	
	public void insert(Node node) {
		head = node;
		tail = head;
	}
	
	public void insert(int location, Node node) {
		Node preNode = getPre(location); // 이전데이터가 없으면 현재 위치의 데이터를 가져온다.
		Node nextNode = getNext(location);
		
		// 처음들어온 데이터 일 경우
		// 처음에 들어 온경우는 앞뒤의 데이터가 없으므로 Link를 만들필요가 없다
		if(preNode == null && nextNode == null) {
			tail.next = node;
			tail.pre = head;
		} 
		// 마지막에 들어온 경우
		// 이전데이터의 pre를 복제하여 node에 넣어 주도록 한다.
		else if(preNode != null && nextNode == null) {
			tail.next = node; 
			tail = tail.next;
			tail.pre = preNode;
		} 
		// 데이터가 있으면서 맨처음으로 이동할 경우 처리
		else if(preNode == null && nextNode != null) {
			head.pre = node;
			node.next = head;
			head = node;
		} 
		// 중간 삽입을 해야 할 경우
		else {
			preNode.next = node;
			nextNode.pre = node;
			
			node.pre = preNode;
			node.next = nextNode;
		}
		
		
		
//		if(preNode == null) {
//			nextNode.pre = node;
//			node.next = nextNode;
//			head = node;
//		} else {
//			nextNode.pre = node;
//			node.next = preNode.next;
//			preNode.next = node;
//			tail = nextNode;
//		}
	}
	
	private Node getPre(int location) {
		Node t = tail;
		while(location-- > 0) {
			t = t.pre;
		}
		
		return t;
	}
	
	private Node getNext(int location) {
		Node t = null;
		if(location >= 1) {
			t = tail;
			while(location-- > 1) {
				t = t.pre;
			}
		}
		return t;
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public void print() {
		Node t = head;
		System.out.println("Forward");
		while(t != null) {
			System.out.print(" " + t.student);
			t = t.next;
		}
		System.out.println();
	}
}

class Node {
	int student;
	int ticket;
	
	Node pre;
	Node next;
}
