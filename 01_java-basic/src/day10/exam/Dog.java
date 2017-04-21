package day10.exam;

public class Dog implements Animal{
	private String name;
	public Dog(String name) {
		this.name = name;
	}
	
	@Override
	public void cry() {
		System.out.printf("%s가 멍멍  짖씁니다." , name);
	}

	@Override
	public void eat() {
		System.out.printf("%s가 사료를 먹습니다." , name);
	}

}
