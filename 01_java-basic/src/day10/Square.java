package day10;

public class Square extends Rectangle {
	public Square(int value) {
		super(value, value);
	}
	
	@Override
	public String toString() {
		return "Square [value=" + super.toString() + "]";
	}
}
