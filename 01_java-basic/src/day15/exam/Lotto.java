package day15.exam;

public class Lotto {
	/** 로또 번호 */
	 private int num;
	 /** 당첨된 회수 */
	 private int count;
	 
	 public Lotto(int num){
		 this.num = num;		 
	 }
	 
	 public void addCount() {
		 count++;
	 }
	 
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	 
}
