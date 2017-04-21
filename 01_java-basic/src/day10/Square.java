package day10;

public class Square extends Shape {
	private int value;
	public Square(int value) {
		this.value = value;
	}
	@Override
	public int area() {
		return value * value;
	}
	@Override
	public String toString() {
		return "Square [value=" + value + "]";
	}
}
