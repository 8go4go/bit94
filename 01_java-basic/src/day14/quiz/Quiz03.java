package day14.quiz;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.FileWriter;

public class Quiz03 {
	public static void main(String[] args) throws Exception {
		copy("ioload/2017/3/27/pom.xml", "ioload/2017/3/27/pom1.xml");
	}
	
	
	public static boolean copy(String pathSource, String pathDestination) throws Exception {
		
		File source = new File(pathSource);
		if(!source.exists()) {
			throw new Exception("Check the source file");
		}
		
		FileReader fr = new FileReader(pathSource);
		FileWriter fw = new FileWriter(pathDestination);
		
		while(true){
			int ch = fr.read();
			
			if(ch == -1) break;
			fw.write(ch);
		}
		
		if(fr != null) fr.close();
		if(fw != null) fw.close();
		
		
		
		File dest = new File(pathDestination);
		if(!dest.exists())
			throw new Exception("Check the destination file");
		
		System.out.println(source.getName());
		System.out.println(dest.getName());
		
		return dest.exists();
	}
}
