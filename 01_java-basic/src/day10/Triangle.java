package day10;

public class Triangle extends Shape{
	private int height;
	private int width;
	
	
	public Triangle(int height, int width) {
		this.height = height;
		this.width = width;
	}
	@Override
	public int area() {
		return (height * width) / 2;
	}
	@Override
	public String toString() {
		return "Triangle [height=" + height + ", width=" + width + "]";
	}
}
