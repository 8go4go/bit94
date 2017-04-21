package day10;

public class Circle extends Shape {
	private int value;
	
	
	public Circle(int value) {
		this.value = value;
	}


	@Override
	public int area() {
		return (int)(value * value * Math.PI);
	}


	@Override
	public String toString() {
		return "Circle [value=" + value + "]";
	}
}
