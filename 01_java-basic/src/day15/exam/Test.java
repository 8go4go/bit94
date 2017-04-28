package day15.exam;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		System.out.println(getExtendedFileName(new File("a.java")));
	}
	
	
	private static String getExtendedFileName(File f) {
		int index = f.getName().indexOf(".");
		String returnStr = f.getName().substring(index+1, f.getName().length());
		return returnStr;
	}
}
