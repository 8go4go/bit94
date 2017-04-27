/*
 *   exam01.txt 파일의 내용을 읽어서
 *   exam01-result.txt 파일에 아래의 형식으로 저장하는 프로그램 작성
 *   
     89
	 19
	 77
	 90
	 총점 : ...
	 평균 : ...
	 최고점 : ...
	 최저점 : ...
 */
package day14.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exam01 {
	public static void main(String[] args) throws IOException {
		BufferedReader fi = new BufferedReader(new FileReader(new File("ioload/exam01.txt")));
		BufferedWriter fw = new BufferedWriter(new FileWriter(new File("ioload/exam01-result.txt")));
		String data ="";

		List<String> scores = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		while((data = fi.readLine()) != null) {
			scores.add(data);
			sb.append(data).append("\n");
		}
		sb.append("총점 : ").append(getSum(scores)).append("\n");
		sb.append("평균 : ").append(Integer.parseInt(getSum(scores))/scores.size()).append("\n");
		sb.append("최고점 : ").append(Integer.parseInt(getMaxScore(scores))).append("\n");
		sb.append("최저점 : ").append(Integer.parseInt(getMinScore(scores))).append("\n");
		
		fi.close();
		
		fw.write(sb.toString());
		fw.close();
	}
	
	public static String getSum(List<String> scores) {
		int tot = 0;
		for(String score: scores) {
			tot = tot + Integer.parseInt(score);
		}
		
		return String.valueOf(tot);
	}
	
	public static String getMaxScore(List<String> scores) {
		int max = 0;
		
		for(String score: scores) {
			if(max < Integer.parseInt(score)) {
				max = Integer.parseInt(score);
			}
		}
		
		return String.valueOf(max);
	}
	
	public static String getMinScore(List<String> scores) {
		int min = 100;
		
		for(String score: scores) {
			if(min > Integer.parseInt(score)) {
				min = Integer.parseInt(score);
			}
		}
		
		return String.valueOf(min);
	}
}











