package day10;

public class Rectangle extends Shape{
	private int height;
	private int width;
	
	public Rectangle(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	@Override
	public int area() {
		return (height * width);
	}

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}
}
