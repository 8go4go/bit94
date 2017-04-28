package day15.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) throws Exception {
		searchFileContent("data/find.txt", "System.out.println(oriArr[j]);");
	}

	
	public static void searchFileContent(String readFileName, String findStr) throws Exception {
		List<String> datas = readData(new File(readFileName));
		System.out.println(find(datas, findStr));
	}
	
	private static List<String> readData(File f) throws FileNotFoundException {
		List<String> contents = new ArrayList<String>();
		Scanner s = new Scanner(f);
		while(s.hasNext()) {
			contents.add(s.nextLine());
		}
		s.close();
		
		return contents;
	}
	
	private static String find(List<String> datas, String findStr) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i < datas.size(); i++) {
			String t1 = datas.get(i);
			
			if(t1.contains(findStr)) {
				sb.append(i+1).append(" : ").append(t1).append("\n");			
			}
			
		}
		return sb.toString();
	}
	
//	- 첫번째 인자의 파일내용을 읽는다. 내용을 읽어 두번째 인자(findStr)의 내용이 있는지
//	체크하여 내용이 존재하는 라인을 화면에 출력한다.
//	- 화면에 출력되는 내용은 아래의 결과를 참고한다.
//	출력형식 > 라인번호: 해당라인의 내용 
}


