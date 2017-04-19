package day08.exam;

import java.io.FileNotFoundException;

public class Exam01 {
	public static void main(String[] args) throws FileNotFoundException {
		Parse p = new Parse("word.txt");
		p.parse();
		
		Words words = p.getWords();
		words.print();
	}
}
