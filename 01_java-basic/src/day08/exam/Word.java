package day08.exam;

public class Word {
	private String word;
	private int count = 1;
	
	public Word(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}
	
	public int getCount() {
		return count;
	}
	
	public boolean compare(Word word) {
		if(this.word.compareTo(word.getWord()) == 0) {
			count++;
			
			return true;
		}
		
		return false;
	}
}
