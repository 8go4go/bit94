package day09;

public class Person {
	public Person() {}
	public Person(String name2, int age2) {
		this.name = name2;
		this.age = age2;
	}
	private String name;
	private int age;
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
	
	public String toString() {
		return String.format("이름 : %s , 나이 : %d", name, age);
	}
}
