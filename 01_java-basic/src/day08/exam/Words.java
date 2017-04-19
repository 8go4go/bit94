package day08.exam;

import java.util.Hashtable;
import java.util.Set;

public class Words {
	private Hashtable<Word, Integer> v = null;
	
	public Words() {
		v = new Hashtable<Word, Integer>();
	}
	
	public int getCount(Word word) {
		return v.get(word);
	}
	
	public void put(Word word, int count) {
		v.put(word, count);
	}
	
	public void print() {
		 Set<Word> keys = v.keySet();
		
		 for(Word key : keys) {
			 System.out.println("-" + key.getWord()+ "  " + key.getCount());
		 }
	}
}
