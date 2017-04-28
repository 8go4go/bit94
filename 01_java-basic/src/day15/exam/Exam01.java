package day15.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam01 {
	/// * 문1> 두개의 파일 내용의 각 라인을 비교하여 문자열이 대소문자 구분 없이 같은지, 다른지를 판
	// 단하여 라인번호와 함께 아래 출력 포맷으로 화면에 출력될 수 있도록 Exam01 클래스에 기능을
	// 구현합니다. 단, 두 개의 비교 대상 파일에는 문자열 데이터의 라인수가 같다고 가정합니다. 또한,
	// 화면에 결과를 출력하는 포맷은 아래의 처리결과 그림을 참고하여 작성해야 합니다. ( 메서드 시
	// 그니처 변경 금지 ) */

	public static void dataCheck(String file1, String file2) throws Exception {
		// 구현하세요~ ---------------------------------------------------
		// 비교 대상 파일인 file1 과 file2 에는 문자열 데이터의 라인수가 같다고 가정합니다~!!
		// --------------------------------------------------------------
		Content c1 = new Content(new File(file1));
		Content c2 = new Content(new File(file2));
		
		String result = c1.compareTo(c2);
		
		System.out.println(result);
	}

	// main 메서드는 수정하지 마세요.
	public static void main(String[] args) throws Exception {
		try {
			dataCheck("data/data1.txt", "data/data2.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Content {
	private List<String> contents = new ArrayList<String>();
	public Content(File f) throws FileNotFoundException {
		readData(f);
	}
	
	private void readData(File f) throws FileNotFoundException {
		Scanner s = new Scanner(f);
		while(s.hasNext()) {
			contents.add(s.nextLine());
		}
		s.close();
	}
	
	public List<String> getList() {
		return contents;
	}
	
	public String compareTo(Content o) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i < contents.size(); i++) {
			String t1 = contents.get(i);
			String t2 = o.getList().get(i);
			
			if(t1.compareToIgnoreCase(t2) == 0) {
				sb.append("Line").append(i+1).append(" : ").append("Equal").append("\n");
			} else {
				sb.append("Line").append(i+1).append(" : ").append("Not Equal").append("\n");
			}
			
		}
		return sb.toString();
	}
}
