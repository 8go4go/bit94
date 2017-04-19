package day06.exam;

class Stack {
	private int stack[] = null;
	private int point = -1;
	public Stack(int size) {
		stack = new int[size];
	}
	
	public void push(int value) throws Exception {
		int index = point + 1;
		
		if(index != stack.length) {
			point = index;
			stack[point] = value;
		} else {
			throw new Exception("Stack is Full");
		}
	}
	
	public int pop() throws Exception {
		int index = point;
		
		if(index != -1) {
			point = index - 1;
			return stack[index];
		} else {
			throw new Exception("Stack is Empty");
		}
	}
	
	public void printStack () {
		System.out.print("[");
		for(int val : stack)
			System.out.print(val + ",");
		System.out.print("]\n");
	}
}

public class Exam02 {
	public static void main(String[] args) {
		Stack s = new Stack(5);
		try {
			s.push(1);
			s.printStack();
			s.push(2);
			s.printStack();
			s.push(3);
			s.printStack();
			s.push(4);
			s.printStack();
			s.push(5);
			s.printStack();
			s.push(6);
			s.printStack();
		} catch (Exception e) {
			System.err.println("꽉 찼슈");
		}
		
		
		try {
			System.out.println(s.pop());
			s.printStack();
			System.out.println(s.pop());
			s.printStack();
			System.out.println(s.pop());
			s.printStack();
			System.out.println(s.pop());
			s.printStack();
			System.out.println(s.pop());
			s.printStack();
			System.out.println(s.pop());
		} catch (Exception e) {
			System.err.println("비었슈");
		}
	}
}
