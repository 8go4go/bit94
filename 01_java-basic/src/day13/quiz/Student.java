package day13.quiz;

public class Student implements Comparable<Student>{
	private String name;
	private int score;
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public int compareTo(Student o) {
		if(score > o.getScore())
			return 1;
		else if(score < o.getScore()) 
			return -1;
		else
			return 0;
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("이름 : ").append(name);
		result.append("  총점 : ").append(score);
		return result.toString();
	}
}
