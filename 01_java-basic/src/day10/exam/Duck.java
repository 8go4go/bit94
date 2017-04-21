package day10.exam;

public class Duck implements Animal, Flyable{
	private String name;

	public Duck(String name) {
		this.name = name;
	}
	@Override
	public void fly() {
		System.out.printf("%s가 날라다닙니다." , name);
	}

	@Override
	public void cry() {
		System.out.printf("%s가 꽥꽥 짖씁니다." , name);
	}

	@Override
	public void eat() {
		System.out.printf("%s가 사료를 먹습니다." , name);
	}

}
