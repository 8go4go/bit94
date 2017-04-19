package day08.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parse {
	private Scanner sc = null;
	private String regex = "[,.:]";
	
	private Words words = null;
	
	public Parse(String path) throws FileNotFoundException {
		sc = new Scanner(new File(path));
		words = new Words();
	}
	
	public void parse() {
		StringBuffer sb = new StringBuffer();
		while(sc.hasNext()) {
			String readStr = sc.nextLine().trim();
			if(readStr.length() > 0) {
				sb.append(readStr).append(" ");
			}
		}
		
		String[] sStr = sb.toString().split(String.valueOf(" "));
		
		for(int i=0; i < sStr.length; i++) {
			if(sStr[i] != null) {
				sStr[i] = sStr[i].replaceAll(regex, "");
				Word word = new Word(sStr[i]);
				for(int j=0; j < sStr.length; j++) {
					if(i != j && sStr[j] != null) {
						sStr[j] = sStr[j].replaceAll(regex, "");
						if(word.compare(new Word(sStr[j])))
							sStr[j] = null;
					}
				}
				words.put(word, word.getCount());
			}
		}
	}
	
	public Words getWords() {
		return words;
	}
}
