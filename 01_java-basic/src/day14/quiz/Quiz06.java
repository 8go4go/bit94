package day14.quiz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Quiz06 {
	public static void main(String args[]) {
		File f = new File("ioload");
		viewDir(f, 0);
  		/*
  		아래와 같이 출력되도록 viewDir 메서드 기능 구현 
  		iodata 폴더 하위의 구조
  		------------------------------
		a.txt
		day08
		      test04.txt
		day09
		      quiz02.txt
		      stream.txt
		day13
		      quiz02.txt
		      quiz06.txt
		day14
		      a.txt
		      a1.txt
		      b.txt
		      Kalimba.mp3
		      Kalimba1.mp3
		      Kalimba2.mp3
		      lec01
		            1
		      Test.java  	
  		------------------------------
  		 */
  	}
	
 	private static void viewDir(File dirFile, int depth){
 		File[] list = dirFile.listFiles();
 		
 		for(File f : list) {
 			if(f.isDirectory()) {
 				String fileStr = makeTab(f.getName(), depth);
 				System.out.println(fileStr);
 				viewDir(f, ++depth);
 			} else {
 				String fileStr = makeTab(f.getName(), depth);
 				System.out.println(fileStr);
 			}
 		}
	}
 	
	private static String makeTab(String name, int depth) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < depth; i++) {
			sb.append("    ");
		}
		sb.append(name);
		return sb.toString();
	}
}