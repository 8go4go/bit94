package day13.quiz;

public class Data implements Comparable<Data>{
	private int num;
	public Data(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	
	@Override
	public int compareTo(Data o) {
		if(num < o.getNum()) {
			return -1;
		} else if(num > o.getNum()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	public String toString() {
		return String.valueOf(num);
	}
}
