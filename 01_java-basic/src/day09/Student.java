package day09;

public class Student extends Person{
	private String no;
	public Student() {}
	
	public Student(String no, String name, int age) {
		super(name, age);
		this.no = no;
	}
	
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(super.toString());
		s.append(String.format(", 학번 : %s \n", no));
		return s.toString();
	}
}
