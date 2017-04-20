package day09.quiz;

public class Quiz01 {
	private Quiz01() {}
	
	public void msg() {
		System.out.println("성공");
	}

	public static Quiz01 getInstance() {
		return new Quiz01();
	}
}
