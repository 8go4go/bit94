package day09;

public class Dog {
	private String name;
	private int age;
	
	public Dog() {
		this("이름모름", 0);
	}
	public Dog(String string, int i) {
		this.name = string;
		this.age = i;
	}
	public Dog(String string) {
		this(string, 0);
	}
	public Dog(int i) {
		this("이름모름", i);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void info() {
		System.out.printf("강아지의 이름은 %s이고 나이는 %d 입니다.\n", name, age);
	}
}
