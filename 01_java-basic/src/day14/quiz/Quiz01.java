package day14.quiz;

import java.io.File;
import java.util.Calendar;

public class Quiz01 {
	public static void main(String[] args) {
		String root = "ioload";
		
		StringBuffer sb = new StringBuffer();
		
		Calendar c = Calendar.getInstance();

		makeFolder(root, String.valueOf(c.get(Calendar.YEAR)));
		sb.append(root).append("/").append(String.valueOf(c.get(Calendar.YEAR)));
		
		makeFolder(sb.toString(), String.valueOf(c.get(Calendar.MONTH)));
		sb.append("/").append(String.valueOf(c.get(Calendar.MONTH)));
		
		makeFolder(sb.toString(), String.valueOf(c.get(Calendar.DATE)));
		sb.append("/").append(String.valueOf(c.get(Calendar.DATE)));
	}
	
	
	public static void makeFolder(String currentPath, String addPath) {
		File f = new File(currentPath);
		
		if(f.exists()) {
			File newDir = new File(currentPath +"/" + addPath);
			if(newDir.mkdirs()) {
				System.out.println(newDir.getName() + " 생성되었습니다.");
			}
		} else {
			if(f.mkdirs()) {
				System.out.println(f.getName() + " 생성되었습니다.");
			}
			
			File newDir = new File(currentPath +"/" + addPath);
			if(newDir.mkdirs()) {
				System.out.println(newDir.getName() + " 생성되었습니다.");
			}
		}
	}
}


