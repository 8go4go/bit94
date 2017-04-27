package day14.quiz;

import java.io.File;

public class Quiz02 {
	public static void main(String[] args) {
		File file = new File("ioload/2017/3/27");
		if (file.exists()) {
			File[] files = file.listFiles();

			for (int i = 0; i < files.length; i++) {
				if(files[i].isFile()) {
					System.out.println("File : " + files[i].getName());
				} else {
					System.out.println("Directory : " + files[i].getName());
				}
			}
		}
	}
}
