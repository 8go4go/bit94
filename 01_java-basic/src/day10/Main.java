package day10;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		
		Random r = new Random();
		int switchValue = r.nextInt(4) + 1;
		
		Shape shape = null;
		
		switch(switchValue) {
		case 1:
			shape = new Square(r.nextInt(100) + 1);
			break;
		case 2:
			shape = new Rectangle(r.nextInt(100) + 1, r.nextInt(100) + 1);
			break;
		case 3:
			shape = new Triangle(r.nextInt(100) + 1, r.nextInt(100) + 1);
			break;
		case 4:
			shape = new Circle(r.nextInt(100) + 1);
			break;
			default :
				System.out.println("Exit");
				break;
		}
		
		System.out.printf("shape[%s] : %d", shape.toString(), shape.area());
	}
}
